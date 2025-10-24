package com.bbva.kbtq.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Utils {

	private Utils() {
	}

	private static final ObjectMapper objMapper = new ObjectMapper();

	public static ObjectNode removeField(String campo, String fichero) {

		ObjectNode jsonDataIn = (ObjectNode) loadJSON(fichero);

		if (campo.contains(".")) {
			String[] parts = campo.split("\\.");

			List<String> lista = new ArrayList<String>();
			for (String part : parts) {
				lista.add(part);
			}
			removeJsonNode((JsonNode) jsonDataIn, lista);
		} else {
			if (jsonDataIn.findValue(campo) != null) {
				((ObjectNode) jsonDataIn).remove(campo);
			} else {
				throw new IllegalStateException("No existe el campo " + campo);
			}
		}

		return jsonDataIn;

	}

	public static ObjectNode modifyJson(String fichero, List<String> campos) {

		ObjectNode jsonDataIn = (ObjectNode) loadJSON(fichero);

		System.out.println(campos);
		String field = campos.get(0);
		String valor = campos.get(1);

		if (field.contains(".")) {
			String[] parts = field.split("\\.");

			List<String> lista = new ArrayList<String>();
			for (String part : parts) {
				lista.add(part);
			}
			changeJsonNode((JsonNode) jsonDataIn, lista, valor);
		} else {
			if (jsonDataIn.findValue(field) != null) {
				((ObjectNode) jsonDataIn).put(field, valor);
			} else {
				throw new IllegalStateException("No existe el campo " + field);
			}
		}

		return jsonDataIn;
	}

	public static ObjectNode modifyJson(String fichero, String field, String value) {

		ObjectNode jsonDataIn = (ObjectNode) loadJSON(fichero);

		if (field.contains(".")) {
			String[] parts = field.split("\\.");

			List<String> lista = new ArrayList<String>();
			for (String part : parts) {
				lista.add(part);
			}
			changeJsonNode((JsonNode) jsonDataIn, lista, value);
		} else {
			if (jsonDataIn.findValue(field) != null) {
				((ObjectNode) jsonDataIn).put(field, value);
			} else {
				throw new IllegalStateException("No existe el campo " + field);
			}
		}

		return jsonDataIn;
	}

	private static void changeJsonNode(JsonNode parent, List<String> lista, String newValue) {
		String index = null;
		if (lista.get(0).endsWith("]")) {
			index = lista.get(0).substring(lista.get(0).length() - 2, lista.get(0).length() - 1);
			lista.set(0, lista.get(0).substring(0, lista.get(0).length() - 3));
		}

		if (parent.has(lista.get(0)) && lista.size() == 1) {
			((ObjectNode) parent).put(lista.get(0), newValue);
		} else {
			if (parent.findValue(lista.get(0)) != null) {
				JsonNode child = parent.findValue(lista.get(0));

				if (child.isArray()) {
					JsonNode grandChild = child.get(Integer.valueOf(index));
					if (grandChild == null) {
						throw new IllegalStateException("No existe el campo a cambiar");
					}
					lista.remove(0);
					if (lista.isEmpty()) {
						throw new IllegalStateException("No existe el campo a cambiar");
					} else {
						changeJsonNode(grandChild, lista, newValue);
						return;
					}
				}

				lista.remove(0);
				if (lista.isEmpty()) {
					throw new IllegalStateException("No existe el campo a cambiar");
				} else {
					changeJsonNode(child, lista, newValue);
				}
			} else {
				throw new IllegalStateException("No existe el campo a cambiar");
			}
		}
	}

	private static void removeJsonNode(JsonNode parent, List<String> lista) {
		String index = null;
		if (lista.get(0).endsWith("]")) {
			index = lista.get(0).substring(lista.get(0).length() - 2, lista.get(0).length() - 1);
			lista.set(0, lista.get(0).substring(0, lista.get(0).length() - 3));
		}

		if (parent.has(lista.get(0)) && lista.size() == 1) {
			JsonNode child = parent.findValue(lista.get(0));
			if (child.isArray()) {
				if (index != null) {
					ArrayNode node = (ArrayNode) parent.withArray(lista.get(0));
					node.remove(Integer.valueOf(index));
					return;
				}
			}
			((ObjectNode) parent).remove(lista.get(0));
		} else {
			if (parent.findValue(lista.get(0)) != null) {
				JsonNode child = parent.findValue(lista.get(0));

				if (child.isArray()) {
					JsonNode grandChild = child.get(Integer.valueOf(index));
					if (grandChild == null) {
						throw new IllegalStateException("No existe el campo a borrar");
					}
					lista.remove(0);
					if (lista.isEmpty()) {
						throw new IllegalStateException("No existe el campo a borrar");
					} else {
						removeJsonNode(grandChild, lista);
						return;
					}
				}

				lista.remove(0);
				if (lista.isEmpty()) {
					throw new IllegalStateException("No existe el campo a borrar");
				} else {
					removeJsonNode(child, lista);
				}
			} else {
				throw new IllegalStateException("No existe el campo a borrar");
			}
		}
	}

	private static JsonNode loadJSON(String fichero) {

		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		BufferedReader br = null;
		JsonNode jsonNode = null;

		try {
			br = new BufferedReader(new InputStreamReader(cl.getResourceAsStream(fichero), "UTF8"));
			jsonNode = objMapper.readValue(br, JsonNode.class);
		} catch (IOException e) {
			throw new IllegalArgumentException("Error reading json classpath:" + fichero + ".json", e);
		}

		return jsonNode;
	}

}

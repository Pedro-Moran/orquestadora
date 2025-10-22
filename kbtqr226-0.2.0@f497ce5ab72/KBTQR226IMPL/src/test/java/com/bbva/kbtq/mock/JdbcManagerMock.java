package com.bbva.kbtq.mock;

import com.bbva.elara.dao.template.CommonJdbcTemplateImpl;
import com.bbva.elara.domain.datasource.DataSourceInfo;
import com.bbva.elara.domain.jdbc.CommonJdbcTemplate;
import com.bbva.elara.support.jdbc.manager.JdbcManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Mock de jdbcManager...
 */
public class JdbcManagerMock implements JdbcManager {
	private ConcurrentHashMap<String, ConcurrentHashMap<String, CommonJdbcTemplate>> connectionsMap;

	private static final Logger LOGGER = LoggerFactory.getLogger(JdbcManagerMock.class);
	private static final String MAX_ROWS = "query.maxrows";
	// private ConfigurationManager configurationManager;

	public JdbcManagerMock() {
		this.connectionsMap = new ConcurrentHashMap();
	}

	public CommonJdbcTemplate getJdbcConnection(String uuaa, String bbdd) {
		LOGGER.debug("Get CommonJdbcTemplate for the uuaa '{}' with database name '{}'.", uuaa, bbdd);
		return (CommonJdbcTemplate) ((ConcurrentHashMap) this.connectionsMap.get(uuaa)).get(bbdd);
	}

	public Boolean createCommonJdbcTemplate(String uuaa, String dbName, DataSource datasource,
			DataSourceInfo dataSourceInfo) {
		Boolean changed = Boolean.valueOf(false);
		uuaa = uuaa.toLowerCase();

		int maxRows = 100; // Integer.parseInt(this.configurationManager.getProperty("query.maxrows"));
		CommonJdbcTemplate updatedCommonJdbcTemplate = new CommonJdbcTemplateImpl(datasource, maxRows);

		ConcurrentHashMap dbTemplate = (ConcurrentHashMap) this.connectionsMap.get(uuaa);
		if (dbTemplate != null) {
			dbTemplate.put(dbName, updatedCommonJdbcTemplate);
			this.connectionsMap.put(uuaa, dbTemplate);
			LOGGER.debug("Updated CommonJdbcTemplate for the uuaa '{}' with database name '{}'.", uuaa, dbName);
		} else {
			ConcurrentHashMap newDbTemplate = new ConcurrentHashMap();
			CommonJdbcTemplate newCommonJdbcTemplate = new CommonJdbcTemplateImpl(datasource, maxRows);
			newDbTemplate.put(dbName, newCommonJdbcTemplate);
			this.connectionsMap.put(uuaa, newDbTemplate);
			LOGGER.debug("Created CommonJdbcTemplate for the uuaa '{}' with database name '{}'.", uuaa, dbName);
			changed = Boolean.valueOf(true);
		}

		return changed;
	}

	public Boolean deleteCommonJdbcTemplate(String uuaa, String dbName) {
		Boolean deleted = Boolean.valueOf(false);
		uuaa = uuaa.toLowerCase();

		if (this.connectionsMap.containsKey(uuaa)) {
			((ConcurrentHashMap) this.connectionsMap.get(uuaa)).remove(dbName);
			deleted = Boolean.valueOf(true);
			LOGGER.debug("Deleted CommonJdbcTemplate for the uuaa '{}' with database name '{}'.", uuaa, dbName);
		}

		return deleted;
	}

	@Override
	public boolean isAllowedDynamicQuery(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getJndiDbUuaa(String s, String s1) {
		return null;
	}

	// public void setConfigurationManager(ConfigurationManager
	// configurationManager)
	// {
	// this.configurationManager = configurationManager;
	// }

}
package com.bbva.kusu.mock;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.mockito.Mockito;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceObjects;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.Version;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.osgi.mock.MockServiceReference;

public class MockBundleContext implements BundleContext, ApplicationContextAware {

	private List<String> stringList;

	private ApplicationContext applicationContext;

	private String bundleName;

	private String bundleVersion;

	public MockBundleContext(final List<String> stringList) {
		this.stringList = stringList;
	}

	@Override
	public String getProperty(final String key) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public Bundle getBundle() {
		final Bundle mockBundle = Mockito.mock(Bundle.class);
		final List<URL> urlList = new ArrayList<URL>(this.stringList.size());
		for (String path : this.stringList) {
			urlList.add(this.getClass().getResource(path));
		}
		Mockito.when(mockBundle.findEntries(Mockito.anyString(), Mockito.anyString(), Mockito.eq(true))).thenReturn(Collections.enumeration(urlList));
		Mockito.when(mockBundle.getSymbolicName()).thenReturn(bundleName);

		Mockito.when(mockBundle.getVersion()).thenReturn(new Version(bundleVersion));
		Dictionary<String, String> cabeceras = new Hashtable<>();
		cabeceras.put("Bundle-Name", bundleName);
		Mockito.when(mockBundle.getHeaders()).thenReturn(cabeceras);
		return mockBundle;
	}

	@Override
	public Bundle installBundle(final String location, final InputStream input) throws BundleException {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public Bundle installBundle(final String location) throws BundleException {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public Bundle getBundle(final long id) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public Bundle[] getBundles() {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public void addServiceListener(final ServiceListener listener, final String filter) throws InvalidSyntaxException {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public void addServiceListener(final ServiceListener listener) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public void removeServiceListener(final ServiceListener listener) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public void addBundleListener(final BundleListener listener) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public void removeBundleListener(final BundleListener listener) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public void addFrameworkListener(final FrameworkListener listener) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public void removeFrameworkListener(final FrameworkListener listener) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public ServiceRegistration<?> registerService(final String[] clazzes, final Object service, final Dictionary<String, ?> properties) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public ServiceRegistration<?> registerService(final String clazz, final Object service, final Dictionary<String, ?> properties) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public <S> ServiceRegistration<S> registerService(final Class<S> clazz, final S service, final Dictionary<String, ?> properties) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public ServiceReference<?>[] getServiceReferences(final String clazz, final String filter) throws InvalidSyntaxException {
		ServiceReference<?>[] serviceReferences = new ServiceReference<?>[1];
		serviceReferences[0] = getServiceReference(clazz);
		return serviceReferences;
	}

	@Override
	public ServiceReference<?>[] getAllServiceReferences(final String clazz, final String filter) throws InvalidSyntaxException {
		ServiceReference<?>[] serviceReferences = new ServiceReference<?>[1];
		serviceReferences[0] = getServiceReference(clazz);
		return serviceReferences;
	}

	@Override
	public ServiceReference<?> getServiceReference(final String clazz) {
		return new MockServiceReference(new String[] { clazz });
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S> ServiceReference<S> getServiceReference(final Class<S> clazz) {
		return new MockServiceReference(new String[] { clazz.getName() });
	}

	@Override
	public <S> Collection<ServiceReference<S>> getServiceReferences(final Class<S> clazz, final String filter) throws InvalidSyntaxException {
		Collection<ServiceReference<S>> collection = new ArrayList<ServiceReference<S>>();
		collection.add(getServiceReference(clazz));
		return collection;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <S> S getService(final ServiceReference<S> reference) {
		return (S) serviceFactory(reference);
	}

	@Override
	public boolean ungetService(final ServiceReference<?> reference) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public File getDataFile(final String filename) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public Filter createFilter(final String filter) throws InvalidSyntaxException {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public Bundle getBundle(final String location) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@SuppressWarnings("rawtypes")
	private Object serviceFactory(final ServiceReference reference) {
		Object obService = null;
		String[] objectClass = (String[]) reference.getProperty(Constants.OBJECTCLASS);
		Class<?> clasz;
		try {
			clasz = Class.forName(objectClass[0]);
			@SuppressWarnings("unchecked")
			Map<String, Class> type = (Map<String, Class>) applicationContext.getBeansOfType(clasz);
			if (type.size() == 1) {
				for (String set : type.keySet()) {
					obService = applicationContext.getBean(set);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obService;
	}

	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public String getBundleVersion() {
		return bundleVersion;
	}

	public void setBundleVersion(String bundleVersion) {
		this.bundleVersion = bundleVersion;
	}

	@Override
	public <S> ServiceRegistration<S> registerService(Class<S> paramClass, ServiceFactory<S> paramServiceFactory,
			Dictionary<String, ?> paramDictionary) {
		return null;
	}

	@Override
	public <S> ServiceObjects<S> getServiceObjects(ServiceReference<S> paramServiceReference) {
		return null;
	}
}

package com.bbva.kusu;

import com.bbva.arch.qe.backend.cucumber.module.BackendTesting;
import com.bbva.arch.qe.backend.runner.cucumber.ManagedCucumber;
import com.bbva.arch.qe.backend.runner.cucumber.modules.Module;
import com.bbva.arch.qe.backend.runner.cucumber.properties.SystemProperty;
import com.bbva.testing.utils.AlphaIntegrationTestModule;
import org.junit.runner.RunWith;

// This two lines "tell" failsafe to use backend-testing in order to run the tests.
@RunWith(ManagedCucumber.class)
@Module(BackendTesting.class)
@Module(AlphaIntegrationTestModule.class)
/**
 * We set the backends to be used. This can be a list, but at least we will need a single backend for local execution. This settings will be
 * overridden when executed in the distributed backend-testing grid with the environment settings.
 */
// For this example we will be using MX KSAN backend
// TODO: Add variables for multicountry
@SystemProperty(name="backends", value="httpbin=https://dev-apx.work.global.nextgen.igrupobbva:8050")

// This sets the default backend to use, from the list above in case we don't specify any in a command.
@SystemProperty(name="defaultBackend", value="httpbin")
public class IntegrationTest { }

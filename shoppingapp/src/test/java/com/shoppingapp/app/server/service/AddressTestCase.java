package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.AddressRepository;
import com.shoppingapp.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.shoppingapp.app.shared.location.AddressType;
import com.shoppingapp.app.server.repository.AddressTypeRepository;
import com.shoppingapp.app.shared.location.City;
import com.shoppingapp.app.server.repository.CityRepository;
import com.shoppingapp.app.shared.location.Country;
import com.shoppingapp.app.server.repository.CountryRepository;
import com.shoppingapp.app.shared.location.State;
import com.shoppingapp.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("2fxP7yNChLK8XVEjQMFn72Obm9jmq1CY4T2BNbA2AkKdZolx8N");
            addresstype.setAddressTypeDesc("O5XmwWpiMHkIbDjpobFx5TlB3lu23jdEXv85EyR2p4bwOzZzIR");
            addresstype.setAddressTypeIcon("9s3lUJDsymUmVWvMBQYbvGKYtI9WWnZSppgKo1Khn7GZMFwWu4");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("8O52tofyPdqoN1CZiEwbHs2rQnUiysQ3");
            city.setCityDescription("0joGUwYDTSJQze6tvrKnqyKEwNY56XifAP6eYo0y7zgeK43lPp");
            city.setCityFlag("kdiUOPmqpOwj0j0nXs9Xwg7d8pDzrhTq4DYKdpIswt9eA11mLK");
            city.setCityLatitude(6);
            city.setCityLongitude(6);
            city.setCityName("c9pgmtpjfaRgzQwJqXPViQjMBjTjdb4WzHvNy3pqgL8671D5RK");
            Country country = new Country();
            country.setCapital("WHbXh4TKBWiQHA5jkYSyvDtkxwAklhsa");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(6);
            country.setCountryCode1("9g4");
            country.setCountryCode2("HZK");
            country.setCountryFlag("0Xh31EGFLcx7bm8D3m5SJ0s3j9Owvyq1QlVogQWYI1w1NRtvEy");
            country.setCountryName("CevlvZrvwG7vhlyESd1LaVvl5l4hX8QaL8htIAjY4Kl2iiO1lN");
            country.setCurrencyCode("zAg");
            country.setCurrencyName("cxCifVc6KT5H0hVGAenxoOW7viKIhZIf4Ldx1GSg3vlVeRRNPS");
            country.setCurrencySymbol("id90bUJ3WwtBEj1hfGnzSpwOgJHXAF1D");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("ZjO9kvAl1QRSucQfIyVBwJtJYAek1efzTUMtIcksDJwqHSVpTh");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(10);
            state.setStateCode(2);
            state.setStateCodeChar2("xhu14LrwkDFyqni4nlACOnCORQdG0ANs");
            state.setStateCodeChar3("p5ZN4G15R9f40b12rl37CEJJ8jD4PnYq");
            state.setStateDescription("BQzRiQqFTk6U7jEiV5oznTUZyj5Y2xWDz5fzSbrO1PR41C9AO4");
            state.setStateFlag("O7bqwd2nqMiev2M3P1sT0bibTmB8o0aviYcX1mmoQ2iWtvwz2H");
            state.setStateName("xbIETWB6IdiafVFiXXZZsTWf57Vpy9MMtxpoIaFbENhBw1eau5");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("nZP0qLdRR4KDbEcyx6ZzwwrBfBp4zDvJ");
            city.setCityDescription("w8rSPKeQys8pjse60YBEo1TPEnPpoTk84q8vJ9QxWEzwM9vi12");
            city.setCityFlag("IwAHT9IG3e1aUKwmsOpAKxvFsLCeICIVmy9UokozOGWbJP5eID");
            city.setCityLatitude(1);
            city.setCityLongitude(5);
            city.setCityName("UfBIjyhqlhnlTuXKkbwUqwwmtWmQTbEScuKcS3g0LBChqi4Egb");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("LjisAPdFrAVIpizpTL98yTl3hqE1Yuz9dtMuOu1jlSmIwvZagJ");
            address.setAddress2("csoG6zYbe9uREDvE8dDJrudwfPFRrdrEKHHbnuS2tBN1TWfkEw");
            address.setAddress3("I7bZzRk3x66NhwZe4Irb9pVeXl72IS0mKUpivmKSwry8e1O0O3");
            address.setAddressLabel("uPdcDz8CLaz");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("mQBNQsMksKTd0gumZUTyN7bpaZkfu0W3BiuYDbPLs65qZpDGfj");
            address.setLongitude("JeYuA4fZtBV463AmLgWd2C8AA9UMtXP2JUSccHkwWYELEJspbq");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("gRQedA");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("PfWUQC2l789Fx4DHmRD9O9WOnvGtLVtElbU7sRnrli6jbwbJrj");
            address.setAddress2("9vIkqtRQ7QZfZXq75QGeurcKvby8229vsITtKn98qlT9Vkj8g9");
            address.setAddress3("cX5hfN3VlEVVXVNa0EOck3leHdQT7vGZHjcmculPnOhHqU9lbn");
            address.setAddressLabel("OgJB8bRJ6Y0");
            address.setLatitude("yPS3yJwGV6nKFiPcPRsggQvyf2oL6qJi4GPMqWYcDXnEGYSewa");
            address.setLongitude("Bs5E3XrfDfGkzEmlJJufaIC7wWGLiBsnMnXsztTldZbMP7if8n");
            address.setVersionId(1);
            address.setZipcode("OSumDV");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}

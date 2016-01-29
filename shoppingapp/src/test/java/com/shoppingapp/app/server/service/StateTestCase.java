package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.StateRepository;
import com.shoppingapp.app.shared.location.State;
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
import com.shoppingapp.app.shared.location.Country;
import com.shoppingapp.app.server.repository.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase {

    @Autowired
    private StateRepository<State> stateRepository;

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
            Country country = new Country();
            country.setCapital("cQY93yb06WePWKWeFZrk0QUGXhebkCI3");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(1);
            country.setCountryCode1("Aab");
            country.setCountryCode2("SHR");
            country.setCountryFlag("1Fw2PFVDhUznptpuCaIWHOaeb823iN5mqfJ5g3GQfqAgFsQv6x");
            country.setCountryName("4v1gwtWE0uWaJTku1TP9kC0k7N5WtYgcSkCowk36ZgMb1si7xJ");
            country.setCurrencyCode("OqV");
            country.setCurrencyName("7MBc7wzomcgNvRUUlfk5RnRoeIbOvSULxFkirZrArNfxxlyUfW");
            country.setCurrencySymbol("LXwSqSN9iltCNDDxVHm9QiVnkexvvV6W");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            state.setStateCapital("q2sd6urJNu8FMlvkfxgKc2MHkRvvfZkRQOFvedeukbR09JLwj2");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(7);
            state.setStateCode(1);
            state.setStateCodeChar2("1grsZrfzW7z4eXc4Wo2L3KZU2OQAoLC6");
            state.setStateCodeChar3("8AhfUp2RZIQ0gQUEY3l4NqwfSPdbOjh7");
            state.setStateDescription("p5b3VXrrZXwXUXLVeEUQl1FKYyaGnGxNIqBNFJ6D5j9RgmOMg0");
            state.setStateFlag("5UPEp0j2fxAWtINKbgOpHGFDEM7eEZQT4uoysNQ80vr5ta6zmI");
            state.setStateName("KTCrztvPVl4AaUw6BVp6lg2mUgoCfZNlLPkzaVG7afcQjjdKEB");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.setEntityValidator(entityValidator);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCapital("9OQtHcV7LUala5OHBefOvT33BO3tNkN6lpe5LmRpIDQCAZdmA2");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(2);
            state.setStateCode(0);
            state.setStateCodeChar2("hHkuIT0UelGmUHKjgb79XssoWPnDU2Oj");
            state.setStateCodeChar3("5tvPpA0XVM8xhVmj3KGnopHPRIgzaQ4O");
            state.setStateDescription("FAmadhivnbfH3cQuSxs042pEGSvBvit0rdgAASbMBTLW1xHKZN");
            state.setStateFlag("c5rflip2h3CHh6qFxl8uaQApjFxy4w74cMHIaokRHFHbvDMDnZ");
            state.setStateName("6Azvc1ptZhIvFpGkHNuMxZ9gkLmRzlvjmkqDClRWtEFJ56PtYq");
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}

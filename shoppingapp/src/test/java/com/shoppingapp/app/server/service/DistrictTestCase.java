package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.DistrictRepository;
import com.shoppingapp.app.shared.location.District;
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
import com.shoppingapp.app.shared.location.Region;
import com.shoppingapp.app.server.repository.RegionRepository;
import com.shoppingapp.app.shared.location.State;
import com.shoppingapp.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class DistrictTestCase {

    @Autowired
    private DistrictRepository<District> districtRepository;

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
            country.setCapital("VWQAVEhA5e3Ctye043DIoRCD59qYFcyF");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(0);
            country.setCountryCode1("6rW");
            country.setCountryCode2("ArU");
            country.setCountryFlag("yyu5bxrrepPRTrx5arilVpZo5x3XS9MMLnzQrIdj5Lp5LCwJGb");
            country.setCountryName("J6U6LYv2zJnO0pLYtH2OLARdsbHpO49sttrzlZIxFaHNuZeDM0");
            country.setCurrencyCode("4ZV");
            country.setCurrencyName("4KF27owz9Nh5LGER2lLMTwk0FSzzQ3JTv25KRxqMW9GgWn7JGf");
            country.setCurrencySymbol("49wKqm2w72TWTvGGf88ujOr6AnrjteAb");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("MkXU1wjlvA8gcUoqBe150k3AGI6mvPs5sskm1hhCCozwqhe1Bh");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(5);
            state.setStateCode(0);
            state.setStateCodeChar2("WoP9W3ZgKtZGAUOCfeJTwh6S4nGjTbqn");
            state.setStateCodeChar3("nQxk6QwXLkAhT3Mr3wAnwKUkkSVqJMCQ");
            state.setStateDescription("XdKw3pfbp3RIolkob8F6w76lEc1ZjrcGzD15axzd78JCzA7Dsl");
            state.setStateFlag("wFwiwjlML7OqONRAJ45qhW6tg1UGRLhEKvV7u752OL2qyvCko5");
            state.setStateName("ZWwWfivuLQQOP98XSiUhBKiqvHKvVFdDl4uLM6NlkJLK9bVkY5");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(0);
            region.setRegionCodeChar2("uLhj6rKiDgcjoQ8QNNCg27iEf7tG2Fq5");
            region.setRegionDescription("DoZh1kThal6VeF1FOumDMIfgcrir8trPBSdWJtnVkbgKuqSXMg");
            region.setRegionFlag("tP2ZWjgumnSyPNX5BA1TgjFjGB656RmFEp6qpHukyUvnZGsnQW");
            region.setRegionLatitude(11);
            region.setRegionLongitude(0);
            region.setRegionName("0GRzR1xHqS616cN0JTpsmfxlEXjgkrTnQaISzAPDJHODCRX6tb");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            District district = new District();
            district.setCode2("LA5R3P9ED5NTpTJlxFVGAFF8dYkyLpo5");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("p6SQFs3XLaBqTb4La6qXJTyOCtatalU5X6NZGaVJCD0XhxBFIM");
            district.setDistrictFlag("ndzZwbMb8n8itV84Z3Fk2ztIEZWHzyTirKlas6XMZKaqsItHCk");
            district.setDistrictLatitude(0);
            district.setDistrictLongitude(11);
            district.setName("q8tE01kToSkQILuWZMC4ax4cmALXT1UDyOpKoeynzPXreVWeaO");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey());
            district.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            district.setEntityValidator(entityValidator);
            district.isValid();
            districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            District district = districtRepository.findById((java.lang.String) map.get("DistrictPrimaryKey"));
            district.setCode2("rNwZSJsPbrDO7w4tLbmJqDEUI5PKf9e7");
            district.setDistrictDescription("biF0nXhpt8Fs9q3Pzmxwn8pMBvK25rIIN41UfKA2kSvL0k8Axf");
            district.setDistrictFlag("fOHjcy0VBl2dZmdskB5tNCB92LwOa8nJk7F5Qeuf45S1NylEnL");
            district.setDistrictLatitude(11);
            district.setDistrictLongitude(4);
            district.setName("wsqBs6i83WXQti97HV0eGqOiwg6pCUFW4yjwhv3oAP3T8R8vz8");
            district.setVersionId(1);
            district.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            districtRepository.update(district);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<District> listofcountryId = districtRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            districtRepository.findById((java.lang.String) map.get("DistrictPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<District> listofregionId = districtRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<District> listofstateId = districtRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}

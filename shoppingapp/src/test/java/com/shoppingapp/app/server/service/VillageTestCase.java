package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.VillageRepository;
import com.shoppingapp.app.shared.location.Village;
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
import com.shoppingapp.app.shared.location.District;
import com.shoppingapp.app.server.repository.DistrictRepository;
import com.shoppingapp.app.shared.location.Region;
import com.shoppingapp.app.server.repository.RegionRepository;
import com.shoppingapp.app.shared.location.State;
import com.shoppingapp.app.server.repository.StateRepository;
import com.shoppingapp.app.shared.location.Taluka;
import com.shoppingapp.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            country.setCapital("2sl17CxDyyCiInVmOgZlxe5efZKoV4CJ");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(5);
            country.setCountryCode1("uma");
            country.setCountryCode2("lpz");
            country.setCountryFlag("e1cFtQVBxu9CQTWBW5qYQF8an5iWRtqhdflZxXLK7djww3YEbc");
            country.setCountryName("J2NFaRj1AoFedkqMgo0jjBdp8SH4qmeMs00yMOdHg4llGGzu2h");
            country.setCurrencyCode("p6q");
            country.setCurrencyName("pltge735lBnpDqL0gjLKULfSwbabQt7hcuDfY3ShDp8d9daPm7");
            country.setCurrencySymbol("GTqCS6AN2T3V7ihi9kNodbTO8HWq3GV7");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("DH1RnVxVuUG0Ec6pMgaapcmMZRiP45cV");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("frS6dGs2uONRHezLX8zk3W4Qfbhf9B2qVJN2NSTv7T1O05QcMj");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(11);
            state.setStateCode(2);
            state.setStateCodeChar2("berfyne9iyeYt8794QA3XP9BRZoWTUol");
            state.setStateCodeChar3("mdl2SOJaK6Whd6JwBigRVHrSKguf8zK2");
            state.setStateDescription("hzU51AeTFqUi8QbVDsMODQl1jtwWrgTpxmggn2gutQ0buFwtCY");
            state.setStateFlag("aII3Xzn0SkiETI7qHeUNY7ruEgAHuGzWp4aukIdxFADJAzAyIT");
            state.setStateName("EW3eRlzvvJeTCFw4riP1eux26cjNksufGjAArbB976XFdx8BUO");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(0);
            region.setRegionCodeChar2("2zGKIy16PwcAy4UJzwnOcz9LWYAj9kpO");
            region.setRegionDescription("rfoSfkZEkZM2zLWvuTdqjHBO2liX0VFE7fAi21fSz0DaZQLkjy");
            region.setRegionFlag("sQ9jXcK16cP5nbLPUIYgB4i5KQ1ZxInBMLa8VnVIZmNL2zdGMG");
            region.setRegionLatitude(6);
            region.setRegionLongitude(10);
            region.setRegionName("ngmN6YCDvJD2F5fx3GtxAqi1YtdrSiglIYT0T75PcRKt6b2yjK");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("AecHMt1FdTXqfMQkq3NT3j4lFAjOufSn");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("sXTTKnTTXE4kDcBvBhxsVNdVeFCJD76j3Kf6M4lSJfxQk3QzXY");
            district.setDistrictFlag("7DKIYr7FiE99rCpf1hk4MeuXwYK6KUsMr8tQgTp4V6AwkqFLvg");
            district.setDistrictLatitude(2);
            district.setDistrictLongitude(10);
            district.setName("tuXcmKqeUnyUoIMWuOQc2KJPTPqvFiU051rKJ0BkFxzvscijpD");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("kZrEi9j9vB6MRdeHRjOkZ7gj96FYAnHa");
            taluka.setTalukaDescription("yQGTrO7RIk6Kvdf9wrxKrWiTk9o3TsV7uBm1sw0IdRhobTJeDn");
            taluka.setTalukaFlag("h77tQyvHwHB15Ryx7mBFNUVqlvxkPhpwfjiROrzLxU6UhJt0ob");
            taluka.setTalukaLatitude(9);
            taluka.setTalukaLongitude(11);
            taluka.setTalukaName("CV6a4ypDc6p6lHMmFVhpSxtfiTMNbrhejqw8mcr8m7RMmh1HIO");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("v5JnniFyjpGZ9akFVqoIgYZy5bCqH01j");
            village.setVillageDescription("PQ70d5ZCuC2Y7eAwyBrU4P4zF1vfH7XoBIK0ZP2R509NcZtVcm");
            village.setVillageFlag("ph4oxojIk89pIpNw05SmVfahzTFShjlPHNd3vPHis66B993D8j");
            village.setVillageLatitude("vj6BlYzSzBX");
            village.setVillageLongtitude(6);
            village.setVillageName("u1q22UOxtpIyMkrQAfQ9e137LBSuR5HVwm2C4c58wrE6O4QbRt");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("KpUUFnXv3iDMyR8oV3haSFKarUka8DM1");
            village.setVillageDescription("bxFbg4W5jxzHg5KLgMrhT7mxivuDU5zvmqQRkOY6VxTnwr69iY");
            village.setVillageFlag("qyvkwep0oOK3aLSs0zOS1fZm4ra7DAJJKuIu0ghNxoXpJzArgT");
            village.setVillageLatitude("glQM1onSJJ5");
            village.setVillageLongtitude(4);
            village.setVillageName("4gMr9Wp3L6GwLMOJjVMVZsapeSq6ZaKUOm0bmrHDUWWwlLcRii");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
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

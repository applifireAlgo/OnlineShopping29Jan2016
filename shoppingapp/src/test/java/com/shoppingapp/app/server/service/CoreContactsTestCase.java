package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.CoreContactsRepository;
import com.shoppingapp.app.shared.contacts.CoreContacts;
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
import com.shoppingapp.app.shared.contacts.Gender;
import com.shoppingapp.app.server.repository.GenderRepository;
import com.shoppingapp.app.shared.location.Language;
import com.shoppingapp.app.server.repository.LanguageRepository;
import com.shoppingapp.app.shared.location.Timezone;
import com.shoppingapp.app.server.repository.TimezoneRepository;
import com.shoppingapp.app.shared.contacts.Title;
import com.shoppingapp.app.server.repository.TitleRepository;
import com.shoppingapp.app.shared.location.Address;
import com.shoppingapp.app.server.repository.AddressRepository;
import com.shoppingapp.app.shared.location.AddressType;
import com.shoppingapp.app.server.repository.AddressTypeRepository;
import com.shoppingapp.app.shared.location.City;
import com.shoppingapp.app.server.repository.CityRepository;
import com.shoppingapp.app.shared.location.Country;
import com.shoppingapp.app.server.repository.CountryRepository;
import com.shoppingapp.app.shared.location.State;
import com.shoppingapp.app.server.repository.StateRepository;
import com.shoppingapp.app.shared.contacts.CommunicationData;
import com.shoppingapp.app.shared.contacts.CommunicationGroup;
import com.shoppingapp.app.server.repository.CommunicationGroupRepository;
import com.shoppingapp.app.shared.contacts.CommunicationType;
import com.shoppingapp.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("vNOmueP3NdF4n9UiqZUbD7GeCdvZ0dgkgD1LrVKcpu0p8uYRNP");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("UR");
            language.setAlpha3("Qne");
            language.setAlpha4("djq3");
            language.setAlpha4parentid(8);
            language.setLanguage("apmHlHycXAJKnOeQcJVKYT7aHFLNs4H5oyqLFTjrvhfdmenD0U");
            language.setLanguageDescription("5FAC7pbWADTKVPbDLqsfOa847qbtlPI7PDEU0rZD7W0D6nm162");
            language.setLanguageIcon("IO3vRTl3r18NF4TCmVtvP5p6XKcQjMDV8Z46HK0LBC2MsByQQJ");
            language.setLanguageType("JJBnSQGk5WADhbZYjXsYxKPnr1190jPb");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("CKFchHrKNWHGTfFdvT1C60AdVKqeWvP6c4ynr8MmtobUXf8pYm");
            timezone.setCountry("8j78lEXhv23DLJVYmght1kYZ3kOTVvPrHl4SfaAQWnsIfIDkUn");
            timezone.setGmtLabel("HLzTx0UlwLhcQ9rESudxNTWAuFwvjKWsGm27tZQfp5TlKkFkdT");
            timezone.setTimeZoneLabel("ImjpaNgyB3UuRWCoX7kUcV1sX3IFkCXCwAE3rPiZsdMmlNI7Cf");
            timezone.setUtcdifference(9);
            Title title = new Title();
            title.setTitles("ug5cUR8M1yTmZNuw1qWP26zzPS7W6qOcEG6NOQPPjmUi8YS5D9");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(14);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Ns9gQFWqPHiIOVLqFVs4IXdUvU7lxG6qB1VSEeQ7bTfVn0j3Hj");
            corecontacts.setFirstName("c4yC80RzC3YO0pVgyIn1Ti42WsYPXW8yRZpEWW4PV0vk9Vht13");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("LKEpWPxTMqCz5h7LSSiqgXRS19bZ0fpGQt0vL81oMMHvlh8uZX");
            corecontacts.setMiddleName("nULmJCgx2PKYxH2eWOfSidV2HvSgmMyJQzxm9HKsXT43v4hOQP");
            corecontacts.setNativeFirstName("aP3bPM4JIoUNr7lu35Qd0j4fIQiYfXCOdO5dEtvIy0HJQkMftk");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("i5j6N6Q9HnGaDohbWlmeZnpeNO2mmCdUAkNFCS4TQHaUyzKGP2");
            corecontacts.setNativeMiddleName("gpdJvT9E3s4zGxnVjoWgo8wkEkhOh9abNBQx0iTAJshwXkbqEL");
            corecontacts.setNativeTitle("BmSiAfogzfMTHbrbTgPVYvjt1b3Mkuedu9o8SkjOrXzI0fisoC");
            corecontacts.setPhoneNumber("Yv424KKIAiOWWvw1HOHu");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("SEgG66z89NORRKhFrVCJaB0aKU6H4TQEqHttdcU2Am1MYta4BY");
            address.setAddress2("7ALWLE9wzqQFE0FKopIUkPZYwQOJ73iN27VAL7AZN6qUsi5ChP");
            address.setAddress3("b6eedRRRj34zLi6hHaBWWvPp0LDWxlERWsdpZLE9RbkT1L6gr8");
            address.setAddressLabel("74l6EEQTNdF");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("LEYDRLAlItgzeYX2Qpsfp2jCWqmhuCa3mi2QgUi3JDYdtcpnow");
            addresstype.setAddressTypeDesc("lcH141Y0DhPpab9dQaI9GxMfqahxpnrdR9qIIvi2xwWSxhsOZW");
            addresstype.setAddressTypeIcon("PkGtXduFbKhT5IWvM8IoKMvLRIWQe2RHR4DCyJn28OkDDJm81d");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("FedSbBGgimf84oIEZK5CnIEXefgpdeUG");
            city.setCityDescription("otO3oWvH8NLq2JAB7J8QblBv2zWoT0kEmnRPGjOnTcUiX1oZL3");
            city.setCityFlag("XjNlSGP8HKsrXBEuuFVbxER9EoxcM06Sa4V8wlKEO8eh5k6Ycr");
            city.setCityLatitude(4);
            city.setCityLongitude(11);
            city.setCityName("Hx66LEtfSCdLPFxb7bymujXSry2OzsvnbOHMXnxNgfEmT0kuJ9");
            Country country = new Country();
            country.setCapital("ztPNXaPl4hVTFRkwnqeOLkf7Q21Saqht");
            country.setCapitalLatitude(0);
            country.setCapitalLongitude(10);
            country.setCountryCode1("ytA");
            country.setCountryCode2("3w3");
            country.setCountryFlag("WCudp5zcddVsC5yUYwyQ7asMozu7Folvii0DPrjV4y78bDrFGW");
            country.setCountryName("pk29MahDKapEZEzFquOMGvrUai09z6XpINMpRISzaH5emZjB3m");
            country.setCurrencyCode("7JW");
            country.setCurrencyName("81GfX1SDxEldyyQWUPsuv5pvOfCtowks2zoWSJiIkSTwQdKr4e");
            country.setCurrencySymbol("ygw5cu7snfV4Mp7zg3i78vThBsJnIQvY");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("xsDODQOmjmibUmhRmGgDmgipBR0MNqrQhUAkaunHmQMeWcx2aL");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(7);
            state.setStateCode(1);
            state.setStateCodeChar2("wA1imaUeg5IF7mKIdEF7hwCNjdnq7avh");
            state.setStateCodeChar3("Tp8lXXiVO7ZWy2jU6ldQ0Z75crmzDNfr");
            state.setStateDescription("X2xieFIQrMLBejrob3E0QOB0q5zKXaKHMrUVokIPRp5tN68N1B");
            state.setStateFlag("iO9l98qP5mI214dnpN6caSvjbMgLluGdstnisxT6dY0BeLnbqs");
            state.setStateName("T25g6aIp72LBRyDshl5TvqDRC7PwAzQ2LWxhVSXTwTB9LoeHld");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("8jcbP8dAW2tCjo8l4m8IoYZzfrvb9CFp");
            city.setCityDescription("MXZqcyusxClOJK81WII3mXQXhyG2WdrIBfoJsU2BUk1cc5zG3t");
            city.setCityFlag("EupKtNQFJfO7P3AOCLGfIPU4Ag2Z6TsOjqHnLymoAXldhVQZUc");
            city.setCityLatitude(3);
            city.setCityLongitude(0);
            city.setCityName("vC4CXJD9VKOXaaG1nq6Jhx2aDPHGL6nZn1NpNNvzd7NrFcTBrS");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("7mhDjNVU2s3gSnPooeE3BVPWQ8HQAXOYFwr7TO4vy5XMrkGIcy");
            address.setAddress2("8vm6iv9R2MdKpWaQEfZu3HpJ9oHsLKnVUGiZe2HaVkwavAygRr");
            address.setAddress3("bFBTBNurUDEy80SeV41Kch0S3Rn9yeRG6zL5V8sxHko2erXs6n");
            address.setAddressLabel("osfIimmwTyE");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("wU1504ZzfOn3A0DmcqpcSnHpjoZgrHKOvLPGv0wkqPDgnKj6gf");
            address.setLongitude("dRW8Of5bD7TQrCSf5ayfKimgrN9KFwnoPHqLAvhY2T7VVfWc7m");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("KghpO1");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("O");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("fPEsErK5KJxJUqF7N4TyMzVwktAoI7tQWACwo51n3hWSlDpHQg");
            communicationgroup.setCommGroupName("LGFA4iQBljA8coMd2Q0EB9AoOyZtJTft6tfeqXJyWY2QsoOLKk");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("gTNhSNEjO8QIzpQAMbMuynDIrtGgZQ60CxJTnPfsbWenCZ6tgk");
            communicationtype.setCommTypeName("FApVRzUPHziR2SiyWr2L9sHfIhm1Eu4Lp1jNO9zyAMrRdv7SV1");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("C");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(91);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ysJjcpvO2tTAYyFZLsqMpkzdTpZrIzLdVGHroscacigVahPLYh");
            corecontacts.setFirstName("v8x7J5117OcdbD6ON1X6YIEJ9WzKBUnl3pQcbJXItJ9eqSV54Y");
            corecontacts.setLastName("tUBJkGo1hJ2yG7p8zLcl0Z7ZpSEUDI84jo8enZHsMORVHcjLRx");
            corecontacts.setMiddleName("VPGnw4YTCG5h2Tp3UpSlmWE1mqLO6AVwkqgiqu5nfB0vXmMraO");
            corecontacts.setNativeFirstName("GgsE0RIoT0nfrxmJzM7dwJVflEd5kJROz8Dk2eEH6kBRbAYgIM");
            corecontacts.setNativeLastName("ZWBIvUMrcMTJqy26piaD1QLTjvfMto0U4KpST3E1PAuwliuWiZ");
            corecontacts.setNativeMiddleName("BOyq0J15vuU8xyeFmiMlyFEY31RUL9r17bqLIJE8CeyedgNPm4");
            corecontacts.setNativeTitle("OywQLiYW5vMdYJH7ZIHdCmjdN8JKKTBR7DOU6mLiy6Cj6ulwYb");
            corecontacts.setPhoneNumber("C2tDrw2Zev10qjYvTSPW");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}

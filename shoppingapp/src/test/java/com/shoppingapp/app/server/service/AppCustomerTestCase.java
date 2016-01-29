package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.AppCustomerRepository;
import com.shoppingapp.app.shared.customers.AppCustomer;
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
import com.shoppingapp.app.shared.customers.AppCustomerCategory;
import com.shoppingapp.app.server.repository.AppCustomerCategoryRepository;
import com.shoppingapp.app.shared.customers.AppCustomerType;
import com.shoppingapp.app.server.repository.AppCustomerTypeRepository;
import com.shoppingapp.app.shared.contacts.CoreContacts;
import com.shoppingapp.app.server.repository.CoreContactsRepository;
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
public class AppCustomerTestCase {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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
            AppCustomerCategory appcustomercategory = new AppCustomerCategory();
            appcustomercategory.setCustomerCategory("omizR3fCq5S6Uide2ZQDRF3HStiCEAec0SNNS6ODvh8zZGFTyz");
            AppCustomerCategory AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
            AppCustomerType appcustomertype = new AppCustomerType();
            appcustomertype.setCustomerType("a7A74Tp5ShXvGN9fj5Vnd42EyI3lsaXJeAmdJwm55ilkI3tyQV");
            appcustomertype.setDefaults(1);
            appcustomertype.setSequenceId(2147483647);
            AppCustomerType AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(125);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("aQbaYbtwQPl4m2e1V0YHPinq8JNCybAihNv3zfpn3c7wJ30QCn");
            corecontacts.setFirstName("kpyaA3AUrVy17KdaH7J5aNKcxKfjgAnsagP0s5yFpNx8OtMuo0");
            Gender gender = new Gender();
            gender.setGender("E98tDsc5Mr1aXasrCCmFzisJ0rYYel6cjZYzCAJugbbzbmpZuV");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Z6");
            language.setAlpha3("Sg7");
            language.setAlpha4("44jg");
            language.setAlpha4parentid(5);
            language.setLanguage("4xkvRR18nR25CJDxi2NO481fOsvMD8bs56Lt0h9rEwnrezEl7U");
            language.setLanguageDescription("icknzkPLsf7B2MZrP019uv3W9HIIQDswYKdq1HnZJyvmOui5ZQ");
            language.setLanguageIcon("ubQ8wafxbPZffOE0mWg2WOZxT1SEe1z5c9eqqoDfW4UAEyLBAq");
            language.setLanguageType("W82tOxEgaJRvOzFVusTBFdCDms5W94dI");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("jnpLDH2wiDwNW23SYJv5Cmf1cARvAwckVddf64U5y9ZyTEqPZx");
            timezone.setCountry("IOor3oUjHLJgjoFkGbW1o5xLip6JhgV8Fgchg0GVWHIsKKkbd4");
            timezone.setGmtLabel("CWU0MUvx4sWo630qLGPb0LWgI61OqwBDcHv1DhKyiVs8zvTRJQ");
            timezone.setTimeZoneLabel("8aMOZzKqHQWjG666GRaCfplaBhJ3oeh5lH8HVzKog3A7wKDxU1");
            timezone.setUtcdifference(1);
            Title title = new Title();
            title.setTitles("RGLZO6NBcAbVK8VJ0K2SdvrXee6SzF0yosJZWNLMEo0XPJ0Iie");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(69);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("zCDgjlIXRXbFWC0Eue7p5m08f7xg4iVQ65QNxlAbV0pJtKdoWL");
            corecontacts.setFirstName("kATUnOKti6QWxr3pahYOCiuwmFSMvTEu1CAxnEQrjUcnpkG76i");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("FbeFbvo4y9qiOyYSkV2pwQQQNE7XalaY2rQFrqtqK3Sy3Q1Z4v");
            corecontacts.setMiddleName("CPzBQgUDc0AIiWhr7NaObBnfvyx2GQn1DNGUsha5QifULz8WYO");
            corecontacts.setNativeFirstName("stYoXkQsA5iO1JdhRGw5lSCEdBBElDR53EXDUhMJGmFJzflssR");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("nXHTJoKpezPC6vKEpYZPgCw7zXmSQsn94xVergSCn6us23scfc");
            corecontacts.setNativeMiddleName("k6LzXcLuPjTapVGrxyWEUyDziVP9cBIE1Jv7K9Ib3F1yxHpmb4");
            corecontacts.setNativeTitle("ZZTTT8wjXS8HV9slK61WDqq3lInK51YIYWG17dDjYUW4rSySuh");
            corecontacts.setPhoneNumber("DrSY1wVPcYvFRUpy6ydh");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("oLx7keOs90RKlVkxGxORxyXAG5z8MYQjWTdSDqcKpz58ohi4pi");
            address.setAddress2("xWZXjV0xNzZGz5Kyf6tiU4vgOIIx6daXyM8oqk6IGn5Ymgf1Yj");
            address.setAddress3("Y86VmPYJ2MVvNcs37Ss0MPiAZYpyEaVjdWunmhy1OogHQK4Nk0");
            address.setAddressLabel("NUlep3uiRyB");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("5gMHLqrqETqQGx8T6kmuQYkbCECLVqQqewpZEOZoGt4oR4pP8C");
            addresstype.setAddressTypeDesc("kP0JIh8IIyo1fzNdzwsEHIy04PViTz0BrFOikPsS7SC0Zh7lJu");
            addresstype.setAddressTypeIcon("Ajx7tZgcyWH4IzIEJ6ce0zzRFSGobqHx1jTYNK0wGS7NJgQgn6");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("Qiutwf7GMtPWrGRNEq25n8gD6KQNv29L");
            city.setCityDescription("4CfaItAS7PWEQswgJhPAyBc4JaWo3NhTCdamHrEbJ0KCn4QEG8");
            city.setCityFlag("IjjQ1dMSqH3PNJwLh73yvOI1o8oSnikSWqEMrlC7hyh4p0Ntow");
            city.setCityLatitude(9);
            city.setCityLongitude(2);
            city.setCityName("jOcgBraUz1pKDTUFcFcMrtkXlkjmozk2rbTWTbrQz2YCWq6rTb");
            Country country = new Country();
            country.setCapital("7sQCQczfax9rOZ1nDyxeTBGLbjmb7pwr");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(5);
            country.setCountryCode1("JKH");
            country.setCountryCode2("nI4");
            country.setCountryFlag("m15JdJmygE0ljxIqYlxjwr4FdytBahpCFLdYHrImPVTuyV0NYY");
            country.setCountryName("r9K8eG03AIlXbQqami1lvsnWvXM7xnWKo7geMToWOCwVIRci0R");
            country.setCurrencyCode("XgI");
            country.setCurrencyName("nLzbKOTwwf0CO8N9jkwsB3Cn6eQUgRvz2sfBCjhGwOmjsAkqhW");
            country.setCurrencySymbol("TEnEr3BfLBVUJat9UtMj6RjUKKjf5zS7");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("X8Sx28VfKh2xR4AZaAEGKbf6azSQhuC9ePvShrHXECOQfwfFBy");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(11);
            state.setStateCode(2);
            state.setStateCodeChar2("moBbyU56JHv62q8OZphbfsXNP6amlyDl");
            state.setStateCodeChar3("sxAY4SpiA1uir1BdhWqoGna8lqvJWp7g");
            state.setStateDescription("ggjW9BJQLRAsNK18lN4ePinal2HygU78XSFFPwWy2DCM33vcE8");
            state.setStateFlag("ZIwTQlPdxHg7gvRHO2Ie1cmMGdAxlTfZaPq75NLLwMPBV1J0d2");
            state.setStateName("qBlC8woCIH9lMvTBaH1XpwqKYarzny1G1aIp0V21AIKrJ2Tn00");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("8SErBHkRKKOgyDr5LwyfUNszThEoQ6zs");
            city.setCityDescription("M2sq8QZCysjIRC36YVsOi598hcBtjkNBSBuqawgLcu5fz2Q5Li");
            city.setCityFlag("H59Q4HKTVyDvkptFtaxhdOen1db7D7aIpiRmxCXRBeMHk9enjb");
            city.setCityLatitude(10);
            city.setCityLongitude(9);
            city.setCityName("JlVgmcuRdUyauuowwzJ6pVgRdP93d0gVbYuFfF2GggmIIJLEUy");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("G7nLfcZnbHDrLDAgXLHxszbGucrfU40z6EPopY4S5snpgLV80Q");
            address.setAddress2("t1YfxUU559BbH0omXuMhoKw2c6FGt1Mrndqc2vckOgG6GuUQXB");
            address.setAddress3("dvc7XoEhv82L6vhjP6Qp7UGoduovEBzCK5tg6zGH8N5ANoVnMs");
            address.setAddressLabel("kluZwAWtCls");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("AdqdusA1DshpiIW9NikNVZXHU8cpP9BHxmyq3qtTFzEmVcM3Kx");
            address.setLongitude("ylfl9roEBWWEiyjfdizotmEhbjWcdAZuG5sdZvAbruqZ1XxA6v");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("Uhlhsd");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("h");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("zEeJwUXgZpitCG2hyQt7SlZpLWPoIdnpUE1hA09gziYOSFbxKD");
            communicationgroup.setCommGroupName("NFgOGKyyLwcBY21HTpDuwqkboWVuACgNkIckgEQFFOnNBoXTta");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("lov0MRxMP4zvNff4k6bcwl8rghbrMn6lU6ehDS0C1AppYniUwS");
            communicationtype.setCommTypeName("N4L7L4tFnB9omfQ5kLuYhhiuoBNclSDG9fNgToKXVIde8TOATY");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("A");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            AppCustomer appcustomer = new AppCustomer();
            appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
            appcustomer.setCustomerName("kWPFxEy85W9SFitJTh4Kv0jlvvjMIZ3IXsXz6bt8zYNhFLts22");
            appcustomer.setCustomerStatus(1);
            appcustomer.setDeploymentModel(true);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.setEntityValidator(entityValidator);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("BYu4ZgauFRRakoxlbtKjBBSTcj4Al5HJjh8hKhI0vhq4YShKkm");
            appcustomer.setCustomerStatus(0);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}

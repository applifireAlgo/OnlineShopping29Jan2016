package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.LoginRepository;
import com.shoppingapp.app.shared.authentication.Login;
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
import com.shoppingapp.app.shared.authentication.User;
import com.shoppingapp.app.server.repository.UserRepository;
import com.shoppingapp.app.shared.authentication.UserAccessDomain;
import com.shoppingapp.app.server.repository.UserAccessDomainRepository;
import com.shoppingapp.app.shared.authentication.UserAccessLevel;
import com.shoppingapp.app.server.repository.UserAccessLevelRepository;
import com.shoppingapp.app.shared.authentication.PassRecovery;
import com.shoppingapp.app.shared.authentication.Question;
import com.shoppingapp.app.server.repository.QuestionRepository;
import com.shoppingapp.app.shared.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(14);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("RrrBK1dMzEDwlkrHih2nfOjbujMmU0YYOmcqKiUUmbIphO82Wc");
            corecontacts.setFirstName("awLxbjnSZavhJAYlnI8V1pGojxAamheRKSj5ymB3TXIDytTSgG");
            Gender gender = new Gender();
            gender.setGender("9E7eC457ym85gjawWOi6rgPNj8eMPZEqIdIJQPIW0nvkGKxZfD");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("nN");
            language.setAlpha3("vbD");
            language.setAlpha4("mgYx");
            language.setAlpha4parentid(6);
            language.setLanguage("1sZLqMQWtSxtYgrPDETuTvrafWhFmuvqeiUDLIgcjDDmdEii9M");
            language.setLanguageDescription("nygsg2iGwQki53UcZ1uTUjABhRjden13x4MI88pBmZenawwomy");
            language.setLanguageIcon("tJS6dEGnT1hos5y80493LmZpNX4ZFnIoBz9Vd5PUSf2FtdEnsg");
            language.setLanguageType("fLMv5ZdYy84WsVaXdq7xKVGy9M5wC4RA");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("4eCUoJJvIIRa5ydLJxXBeaJBUCBSYlKWLR5pnsdeGdH5XghXjm");
            timezone.setCountry("iIIUvKoMDgXnu4145IagkhJndiWE9880n5WMrpfUSzq2u38PFm");
            timezone.setGmtLabel("58hujZTyldSq9AhKp7hKCeoTeBMF5bSrTDqyB9mmNHq7fICaf9");
            timezone.setTimeZoneLabel("CET2VHFq6M0zYfIndZI5bngEHfhO8ey0u7zS6RbZSC2h0N4Cpu");
            timezone.setUtcdifference(5);
            Title title = new Title();
            title.setTitles("IBYm8DiOqzCfscnMjQbBiZZhGHdcVtsugHC2WyxGDyd3pC1r6I");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(33);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("dEWmXnIv3a8Biw8GIgkIiwIeiF7yTASFLfJrHHIa1EGOMVteX1");
            corecontacts.setFirstName("c8ufhkrYoUaXL43LHKFVJKIsGWWgaEBOez9vZL0vewumcvoC4n");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("EcdssuuufgXPmcsZGZprzAkKpI6bt47QjEb1BSurbRXtxdqPBl");
            corecontacts.setMiddleName("GCaQ3qBCsiUfCE9xCR87F9nFcztLAPjYdIAET2zEa7Dg3moJPF");
            corecontacts.setNativeFirstName("PnSNWapeKtRoEw18H4fFMLoPlC4CfVh1iCfWUB9g1pA5Y8Pqay");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("iYLp6uAVPVnfj6WjD3ugrilMUWtyL251K8FFv9e0KTtAzHn2hg");
            corecontacts.setNativeMiddleName("6JpcwDastWYs4JsVNbtFyx9hl2d5N7vzIxi5SghoKUeyNfKB2i");
            corecontacts.setNativeTitle("hlsjAFZeONWSlInKACxfvv3PRNAjokhCzkPBtws0aUfZhBmI0y");
            corecontacts.setPhoneNumber("IX5rFf55KDJPkNOcZ75c");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("GE35edZm9DP05XV32pY3wZwAow5kuQBBkosVmOAptO6di4mXRs");
            address.setAddress2("P5qrK9gFY15tDnyhkBta5SuGbrxgsbr7rbBYExptxIf60Zyiq7");
            address.setAddress3("rRNqh1E7nLkb9NCN3Ia1c3UUeNxclWLAAHzQIIvdoZvYMu2rLV");
            address.setAddressLabel("rm6aZ8Q2jU2");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("3jLO9nP7PF8xifEW1FqQDN4U4eIDRgjS0BfdaJ0nVC753FifAv");
            addresstype.setAddressTypeDesc("5a7Hp5WGaer3YkO7yg4jbmpwLEJAiOtx2eTU2yvZg8TUaUVoVf");
            addresstype.setAddressTypeIcon("oTdTPoqsNzDbizNmSlCeoIYBPRaah9leIEgvtI7WELytXgiKHG");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("p5P0meGKVBSoCVnNZLTUpqWeLxiiuO62");
            city.setCityDescription("mjQnogpFoJhJiwEYMiVp7KeEFKE1MKC4qnY38rAatayXn3JKIF");
            city.setCityFlag("0MFS1WneTuYkymdrvHfb1F7VhOkO3VAqI8jEC7Tef6gAF8sVFC");
            city.setCityLatitude(7);
            city.setCityLongitude(3);
            city.setCityName("M0rP7zGkIvVZOMl4TWwt6k2pqLSF4HCkvgoCvBFMK2qCWzj02O");
            Country country = new Country();
            country.setCapital("eaXQTXQjXZF5s9CQ2ygevQjlXH6ItgaQ");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(2);
            country.setCountryCode1("VsL");
            country.setCountryCode2("yQ9");
            country.setCountryFlag("4XdVz8XWhl7tGnBEFTovACaV2T4G990x91877J7FntzHF0OvWu");
            country.setCountryName("DP85fq0ovoz4ZETqyOV2ZHY9ds0wpqQCqMAZJu8GkB6pYVyYdg");
            country.setCurrencyCode("hvb");
            country.setCurrencyName("vnHpGSh2op2iWYPrAKcGhZMO2Ke9IGx08l1nfkkUMTgCGw3M7u");
            country.setCurrencySymbol("F0Oke2ervqpe3FMKvxTMUWz4KeCgbE8X");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("ItcWyG1FE5fa8p6FyhKtPTnhb2W9famTjb8JgCSNKuUXRHgmFC");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(10);
            state.setStateCode(2);
            state.setStateCodeChar2("i8fPMiBwqrl9QAvgIsHq3naVUwODxRa9");
            state.setStateCodeChar3("TzNzSt9QAtNDzcIInxUp9ROZDmsPP85e");
            state.setStateDescription("jrEiR24HCOkTO946xlxvkJWedNhSnIkzSNqUYnVKuPD6uUYRw9");
            state.setStateFlag("y8ibMKyysHLd0ahwSUI35lAdPG4ZRcofkLmUsKqQq5pZAnWnIb");
            state.setStateName("KadrxgkErgLtgOeR0UaGzVbNaY4rMNVnOw0fZD2rB9a6OZwFaX");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("9njt8nq4xaQj49Z14h0gcR0KjQWZQUVc");
            city.setCityDescription("oicR0HTrDd2ivN9fAxRqp328znGdCON4iCo5G1DzR5Zs7H4EmK");
            city.setCityFlag("qixwUOb2DfSIGyMBWokImTmh8F5IqCBnE6wTVbro43QxgcTSw5");
            city.setCityLatitude(4);
            city.setCityLongitude(0);
            city.setCityName("ugfDzThEVmDGZfGzU0Vf6qKEALXOl8Jx43kQoXRWxl0hn6mEQ6");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("dd5VbkMLFGXoVpUONUirCMtf6TlZdWNytvG3HrCOnt6ROdUCpR");
            address.setAddress2("Efr8kULW1VaJ04BJBTWIxyZlOaoGzrJdbGHGnAqdCbBIEWRHdl");
            address.setAddress3("o8KB2oIf9BVBFmOuutHboCb5jVT13rXzSTFtHQv6tNsDJWstpW");
            address.setAddressLabel("RIs9JbolQLY");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("AuaQfJn8KkObM7FxZu7TUTZWBJL3tq1V9btB53lQrEwRTy7PPq");
            address.setLongitude("TkILTC8oETne2YF5TnGgBuKe94uYDAhl7R7UWbmUJNnjQrm04O");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("grcKTA");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("s");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("ayHXJvgi21OpfI24OCw6VNhcc3voUQHvQHYOJJCqH0mi7577uk");
            communicationgroup.setCommGroupName("8d0qQMftoUGvAHhBsrnzKRZUtQhnovc6z039lsJfPwlhp7TtnU");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("W9108MyeLaptWlbNerCdGuxEJgg6uKEX1c3UJQT8ykKYMZpPJq");
            communicationtype.setCommTypeName("eFlbX1dZD3jkupPGaNu6OkJOhHvdokUo7wn4szQ6yjheKuXtwM");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("j");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("QakM6Q5CKe8UWnOT6WjcbZdGNj44epjv55FHTNLRVkpcFGIIqb");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2048);
            user.setUserAccessCode(7);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("v42TiCcVlp5VcMQ6zr8QXjiWll9oPryehZ4IYgfFyCBlUvGgkO");
            useraccessdomain.setDomainHelp("OuGHbtz1B2aCLkK57l5tcj825ZH4Sj62gyyj06yZFOfvGuIkUz");
            useraccessdomain.setDomainIcon("gPd5HElAmUnrVTwcQLABNqvg7qpQjV0L4zbeGzQZVrO2ZZdukW");
            useraccessdomain.setDomainName("LbueT5YrcKvvrRSTsYYIZ5UxWnGeWmpaRKH45k7WYhSBLuzPVJ");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("XwGGi7SawBTDOADu9rFrBdgMIMSIk7V7I5vi85NHp4gum8oamt");
            useraccesslevel.setLevelHelp("6tfzSuh33AFIyR08DfDn3PNOQ6QP8eRtCpAyyp7GyF9Wu1dun8");
            useraccesslevel.setLevelIcon("xjic0yAltYnyOAACnCW00ewNg479VTFjdBhCa0c4qhbfzfrFD7");
            useraccesslevel.setLevelName("RWCs59PYiYqMGW67NKZnqXUUdjA9FsrXAXXlYyG2dSK3Y6VtZg");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("QMoHSFjHUnlV8l6NRPy38ykyZho4sdIVUKbdNzn0Np6UPIgEKs");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1916);
            user.setUserAccessCode(10);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("lXNrmryA1fuhmNPjIuOdKzwIsw0qgYOyZ8MpRk0vjoJ1U9epBY");
            Question question = new Question();
            question.setLevelid(2);
            question.setQuestion("RR0J5wqkYpzj0mdyS45ytsMjG8nslWtVVxCLEDxtbl5npqeWa9");
            question.setQuestionDetails("Z");
            question.setQuestionIcon("mkY9dYW3Z6NtX0iLapydamggJAH4zWJy5IqN8Y3b5eV0P1Zdwz");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("3jsNzMv0FRC6rH16srUUG4imVb9XiLhzYQj4ScLOXWlFUhSPtP");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("kS5kQioz904le8ngJQz5wXBW9aHGQtjibh57VRwelJ0e3wnIOV");
            userdata.setOneTimePassword("d9hvSeOuAqu7pP8MQarJnT3pxWGVpb13");
            userdata.setOneTimePasswordExpiry(0);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("sqCb16PJLj2NjB8Zce8EgkgkzMpsXfKiP1yEDCmwm1VmAcwcRA");
            userdata.setLast5Passwords("H209pePmP4unzWl0n3L4o8yP8NKXdpUj2LfSkN3RxaG5vgDVKs");
            userdata.setOneTimePassword("9yo0DCnSrZT6cyH7SpYZn93wVJFXJXGl");
            userdata.setOneTimePasswordExpiry(11);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("pAfz6zhbL2bqOOSB4EAFt3ctrF9B2SQ1ZTGcI541SMsqQMBJkL");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(1);
            login.setIsAuthenticated(true);
            login.setLoginId("KFk4uh22K6WDoR0fIWCIAvoh0rjOEijqs1iMJKyoCI2V7oqE9S");
            login.setServerAuthImage("ChT30HwIIDan98WWmEWDqmVQ4ZHDb61Y");
            login.setServerAuthText("xMGg2MTngJGge7NU");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(9);
            login.setLoginId("ZrmbQpvbZJlrRnRSztrZ2CxJpgrjOx6vYQXcmW3PgawzD1wDJI");
            login.setServerAuthImage("g4641tpqWK0uMPa5n8SFRxmMQb7tAjVF");
            login.setServerAuthText("IMmoTBUTH45VO7ww");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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

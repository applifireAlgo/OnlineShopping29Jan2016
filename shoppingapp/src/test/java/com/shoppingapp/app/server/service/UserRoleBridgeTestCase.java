package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.UserRoleBridgeRepository;
import com.shoppingapp.app.shared.authorization.UserRoleBridge;
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
import com.shoppingapp.app.shared.authorization.Roles;
import com.shoppingapp.app.server.repository.RolesRepository;
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
public class UserRoleBridgeTestCase {

    @Autowired
    private UserRoleBridgeRepository<UserRoleBridge> userrolebridgeRepository;

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
            Roles roles = new Roles();
            roles.setRoleDescription("qblkaHerw3gO5Zz2E13UawuThBdJw5QQr6ezBFrfKlvJL3XbDs");
            roles.setRoleHelp("lSqLmJQ7veNFB93WDOsMQ9TvWJ43T4RkvtVdi59gx0Ufc7NSCb");
            roles.setRoleIcon("0T2pQCAYxMAdWaySpylwMQ81Ixn47Ud1y7p1w9tjYBjhxXyG25");
            roles.setRoleName("MD9v8WaHXQJAnEU6IgklKLeHVTJbeDRT6vpfA7S9EhghQGin16");
            Roles RolesTest = rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("EJbusmDzs834t9M2miiLwDhXAB5WzzPoFYLskfSqKMdYeD5lGm");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2221);
            user.setUserAccessCode(2);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("nSnMHUHpVMge58IDv9mJ8V1xCaEsxwPvCWV3p9RLsaJjII8CZ7");
            useraccessdomain.setDomainHelp("ptBfq0VcBFeXFuTE50WCbXsdrOD2yc763huTA1MoByG57Zvd0n");
            useraccessdomain.setDomainIcon("OYfCSV9KQ0oIZfW2NmlWh7754Uwd6GwvaHBzxSdHJ2opto2ECS");
            useraccessdomain.setDomainName("XsHdAkwqhWosYYtM5rhChJV02686hj8oeNjGD9mgagJRWID5jU");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("PBpkaquF33M5rkWMFKOwMUgdjoxLmkfvSX6yMXBJAuSqSOVot7");
            useraccesslevel.setLevelHelp("1yPcY1wuPWLsdVCacmZBhHoo6HbbRpgND3yQ0FUhIRBXTb5Czi");
            useraccesslevel.setLevelIcon("9Adu4AvwEtlQ7qxPleLz7SXppTzIalqqm7RjkSs8uAYWZaYK03");
            useraccesslevel.setLevelName("hYDu57gGprQxYa92S6eBLAfyE2KPUuFIHzpbLpl6ZZ9801UWyQ");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("szfrAz4auKEzmD78HEkolVAbpKj2a61nOeQJURoLUDzHlPsJz4");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3352);
            user.setUserAccessCode(10);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("Xc9dQa8B8IAShJNznKeJomSkEQ95lhBzMDQMKPazYXgCPUMfOc");
            Question question = new Question();
            question.setLevelid(8);
            question.setQuestion("71nbz6tyrMNIUwSXhnFeFaBXetjiMcmOoPT378lsEA79JAqvSO");
            question.setQuestionDetails("p");
            question.setQuestionIcon("dtb5ey1tSp8SPl1DoJKmtTDGVHrcYhBfBDwVYBdfM9PdcnBl1r");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("TWjNOdNg4M8lTNNvlLFS1rvE5o5nQznFrwLuw9bumy2hieVbMX");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("1rxCfGHNKJ9H7Cfi3Vff7klSaSU8ZJMRmT7ndlzpKW2Gd6wRtn");
            userdata.setOneTimePassword("2CAmW2nGIOTlQ9Sn2mphyWylsogLzMli");
            userdata.setOneTimePasswordExpiry(5);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("I7vbNwW0udRLo9A4XYyFhl6L8SY9t8msXOXLj9RtikiF5oCL1A");
            userdata.setLast5Passwords("iZVMGBDlr0IB7IkgIs8VPIAcCj4bmRsexoL3Ge091TPIsF6Q2M");
            userdata.setOneTimePassword("4rvkOlMVCh1P504MXvH09AvJ7YdWBjXe");
            userdata.setOneTimePasswordExpiry(11);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("grs6VXK1BGg6YFiiqTfR5DLSxhzKHS2CZWe8536VgGsCXeuUhf");
            userdata.setUser(user);
            user.setUserData(userdata);
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            UserRoleBridge userrolebridge = new UserRoleBridge();
            userrolebridge.setRoleId((java.lang.String) RolesTest._getPrimarykey()); /* ******Adding refrenced table data */
            userrolebridge.setUserId((java.lang.String) UserTest._getPrimarykey());
            userrolebridge.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            userrolebridge.setEntityValidator(entityValidator);
            userrolebridge.isValid();
            userrolebridgeRepository.save(userrolebridge);
            map.put("UserRoleBridgePrimaryKey", userrolebridge._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            UserRoleBridge userrolebridge = userrolebridgeRepository.findById((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
            userrolebridge.setVersionId(1);
            userrolebridge.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            userrolebridgeRepository.update(userrolebridge);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByroleId() {
        try {
            java.util.List<UserRoleBridge> listofroleId = userrolebridgeRepository.findByRoleId((java.lang.String) map.get("RolesPrimaryKey"));
            if (listofroleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.findById((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<UserRoleBridge> listofuserId = userrolebridgeRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.delete((java.lang.String) map.get("UserRoleBridgePrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}

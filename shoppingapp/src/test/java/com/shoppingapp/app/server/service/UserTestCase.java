package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.UserRepository;
import com.shoppingapp.app.shared.authentication.User;
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
public class UserTestCase {

    @Autowired
    private UserRepository<User> userRepository;

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
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("RnuwmtDSa88KbKGa1BkKtPrvtcapHy0mVXdE4PFgmx4l6lpuoU");
            useraccessdomain.setDomainHelp("D72kNXjF9MPXzADi09I9yVtrC38cxRBFdnP03y51pFuxq2JSNb");
            useraccessdomain.setDomainIcon("vO4jxUFijmuck4NwrRFuBdjmxxqw52RoCT5OYNcuWUsnWxkPyA");
            useraccessdomain.setDomainName("xQJPSteqYEXDijc1Mnt4vwMOlC7vllTzduzODtAh6rqFpdybXb");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("mQdFjZb31Q9EJJQ4Kn9hQD9QH5tU6swvv2ZH6trY0VIP7i8Fla");
            useraccesslevel.setLevelHelp("7KUsWvgNlDJlh0saiK0QjFlwhQ5T1ytjda5YRGufAnoVOaJcre");
            useraccesslevel.setLevelIcon("vJ5Laa77Gd6jsoM5QsEgKXqeFolL5IO9AOV0J7bWRHuqkfTduL");
            useraccesslevel.setLevelName("nDriUMcPnGVGChQX12B5sBOJRgFwkermeeJAnoQ401LcM3EniS");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("kxGXErSuHxCSskCXxl3k7wGm5JohvnMAQHiAMdlGbEVcdCv09d");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(231);
            user.setUserAccessCode(10);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("AoY6cDC9iVmMbJeXGMCxlQwKNIJuCnQAAIGUZUBHkfOcLb18CC");
            Question question = new Question();
            question.setLevelid(3);
            question.setQuestion("uYyQcbMP1tkMYWKKWpLPyJL59SIkWcyyhn1roOiEFyKwm7bgRL");
            question.setQuestionDetails("L");
            question.setQuestionIcon("jvfbePZTotG1RVFPjcTqPdiSelrqpvG3Qz6KUUlOc544s39qqJ");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("oZ11nHJ1e5EUpmZRrj67Z0ETVaJsXy8Q4vIIdRH0FcCxzfeP4g");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("kIMz4c5FvZsSb3oYzpytqqAKBMob6gmbcN8jjy5HlAM4t1xuAO");
            userdata.setOneTimePassword("7dow8uVEVTI4rodiqbKUqFlwPp5NUZw2");
            userdata.setOneTimePasswordExpiry(7);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("hrwpYkDJ3mUXfLhDtDaeD6wfqRYi4sXW4oka6yGapn0zZIOHnn");
            userdata.setLast5Passwords("ITPHQYvHHu3AT1GGblzcgyigLPlbpIK5Xt8XYEY5r3vMEQT783");
            userdata.setOneTimePassword("hdYfwgfp78qTb9Siss7lbZytnOqApQ0U");
            userdata.setOneTimePasswordExpiry(11);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("0loIkq7siOe2nRNCm2LmwcLU3anUfmvtfucMK60uEAdX0rNRgG");
            userdata.setUser(user);
            user.setUserData(userdata);
            user.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            user.setEntityValidator(entityValidator);
            user.isValid();
            userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2findByuserAccessDomainId() {
        try {
            java.util.List<User> listofuserAccessDomainId = userRepository.findByUserAccessDomainId((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            if (listofuserAccessDomainId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2findByuserAccessLevelId() {
        try {
            java.util.List<User> listofuserAccessLevelId = userRepository.findByUserAccessLevelId((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            if (listofuserAccessLevelId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("UserPrimaryKey"));
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}

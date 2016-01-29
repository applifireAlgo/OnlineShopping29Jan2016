package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.OrderMainRepository;
import com.shoppingapp.app.shared.onlineshopping.OrderMain;
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
import com.shoppingapp.app.shared.onlineshopping.OrderDetails;
import com.shoppingapp.app.shared.onlineshopping.Item;
import com.shoppingapp.app.server.repository.ItemRepository;
import com.shoppingapp.app.shared.onlineshopping.Brand;
import com.shoppingapp.app.server.repository.BrandRepository;
import com.shoppingapp.app.shared.onlineshopping.Category;
import com.shoppingapp.app.server.repository.CategoryRepository;
import com.shoppingapp.app.shared.onlineshopping.Product;
import com.shoppingapp.app.server.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class OrderMainTestCase {

    @Autowired
    private OrderMainRepository<OrderMain> ordermainRepository;

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
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("0ceQSNkzhIrkJkBJI9jv24ll3xjJC1xJ65MeLtDTfY5Kg5qSvo");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2586);
            user.setUserAccessCode(2);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("I7UbxkJSjUFBmtLunzakDrzyXie1xiqV5ZZxWwyPxm7FLetezD");
            useraccessdomain.setDomainHelp("12dHa8FVrmmWjbs2IxJTmUFLTP7JpVjGRpUchx258JW1gH1a5P");
            useraccessdomain.setDomainIcon("Lm5p9bSwzclx2wDgsfqMUYO0ro5wLE2DX2tdm6FrjIlFwdNODn");
            useraccessdomain.setDomainName("lVHtg5IQ6jal4Tz6CjcQvssfLwXua1ADDp4AkF717hOf6RXSPH");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("tyRpJYLwTwTUlVwID6p1uZNKEVS5kauNnQpHStwfa3bWrKy2tj");
            useraccesslevel.setLevelHelp("IX7rEyKPZGhdPKETsNyNqlLzRzeo3hg6ZwOEiQ8xWmdOQqxty5");
            useraccesslevel.setLevelIcon("03R1LmKjTWTFq1vDltDrXxGilWhVX1DeEoFiKjKnl31pwHMiWs");
            useraccesslevel.setLevelName("vPP8QhrLVZAl5N5tSOaOyqGq7m0bS0DwIAOItpmYGuCj0g6HHj");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("aMFyy3dPwnUnuzZx5h33WRt6Hj0Hfrv9gFNBzlkYwlYA85H4Dm");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(772);
            user.setUserAccessCode(4);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("tWpNVIJTO3gV8t5EQS1EFgc6LtdHJv0yTHMwDR39wF1Pxrgg9e");
            Question question = new Question();
            question.setLevelid(1);
            question.setQuestion("BZhqJ1yO4L4LONPUZ2XmTqET0AlxNYI30J70mRcjHrdWlkVBKP");
            question.setQuestionDetails("L");
            question.setQuestionIcon("oyTaR60xQCPGxHh2wpxyyxKh3LqqR2mv7IX1ePz6zj6kpkgm8a");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("X5CQ91ta45XCTglwGDPFVoh3TMulf5UT4bNmRAP1krJ3KnM51z");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("lPehtCZI91EPud49niJUQ2hsHXwc2RMFjJbuFKKuvQQXulJUR2");
            userdata.setOneTimePassword("P9TXKWyPFM6aVeigjwVLEgAz0QvReamy");
            userdata.setOneTimePasswordExpiry(10);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("Ewp1qwXBtA1b4urMKOrldRYUFsMEAkB5KjrGeVmdSLWlxAOuqz");
            userdata.setLast5Passwords("yzGUtXzpDEslgOcS8IfhnLMyNwlCydRM2PQ9b1NLiN0Caxz38C");
            userdata.setOneTimePassword("LwEbwrEMeElhiqOM9EioJegd8YnTq23O");
            userdata.setOneTimePasswordExpiry(3);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("GCE3ZXCncWEWKj7DJfrKXERG5iGJNf8c2dPKhd0a6KJVtnyBIV");
            userdata.setUser(user);
            user.setUserData(userdata);
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            OrderMain ordermain = new OrderMain();
            ordermain.setGrandTotal(12.34);
            ordermain.setOrderDate(new java.sql.Date(123456789));
            ordermain.setUserId((java.lang.String) UserTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<OrderDetails> listOfOrderDetails = new java.util.ArrayList<OrderDetails>();
            OrderDetails orderdetails = new OrderDetails();
            Item item = new Item();
            Brand brand = new Brand();
            brand.setBrandName("gfXru3Jz5mguQNaw2gjRTRNOPuZHNo9lQWh9HaG6Zjad3BdszU");
            Category category = new Category();
            category.setCategoryName("2Yt4Y8a3D7Ss2vrOcAlH9kNRgyrVBTb6LLs1rigiE548fHEGMQ");
            Product product = new Product();
            product.setProductName("6PyJkkrretHfBWXdSipI69bV4JCF8xC3kL7egaZ8AN96RyvKR8");
            Product ProductTest = productRepository.save(product);
            map.put("ProductPrimaryKey", product._getPrimarykey());
            category.setCategoryName("0sp1cik2SnMQVBbsszbOXb7bYKtyI08eLzWmLN5GXtJR8l7sWa");
            category.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Category CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
            brand.setBrandName("mQqzB5wU3qdnVWrXjyXDRWCWDalJjQtfaNbwoqaYGbVyuKKp5t");
            brand.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            brand.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Brand BrandTest = brandRepository.save(brand);
            map.put("BrandPrimaryKey", brand._getPrimarykey());
            item.setBrandId((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setItemIcon("d");
            item.setItemName("ygW8Bn4AOBPHGF5xOJO26ZPxNREJEz5Bgc1ZcEdXwVgRumdC2i");
            item.setItemPrice(12.34);
            item.setItemStock(610219191);
            item.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Item ItemTest = itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
            orderdetails.setItemId((java.lang.String) ItemTest._getPrimarykey());
            orderdetails.setItemPrice(12.34);
            orderdetails.setItemQuantity(157579748);
            orderdetails.setOrderMain(ordermain);
            orderdetails.setSubTotal(12.34);
            listOfOrderDetails.add(orderdetails);
            ordermain.addAllOrderDetails(listOfOrderDetails);
            ordermain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            ordermain.setEntityValidator(entityValidator);
            ordermain.isValid();
            ordermainRepository.save(ordermain);
            map.put("OrderMainPrimaryKey", ordermain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Autowired
    private BrandRepository<Brand> brandRepository;

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Autowired
    private ProductRepository<Product> productRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderMainPrimaryKey"));
            OrderMain ordermain = ordermainRepository.findById((java.lang.String) map.get("OrderMainPrimaryKey"));
            ordermain.setGrandTotal(12.34);
            ordermain.setOrderDate(new java.sql.Date(123456789));
            ordermain.setVersionId(1);
            ordermain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            ordermainRepository.update(ordermain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderMainPrimaryKey"));
            ordermainRepository.findById((java.lang.String) map.get("OrderMainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<OrderMain> listofuserId = ordermainRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("OrderMainPrimaryKey"));
            ordermainRepository.delete((java.lang.String) map.get("OrderMainPrimaryKey")); /* Deleting refrenced data */
            itemRepository.delete((java.lang.String) map.get("ItemPrimaryKey")); /* Deleting refrenced data */
            brandRepository.delete((java.lang.String) map.get("BrandPrimaryKey")); /* Deleting refrenced data */
            categoryRepository.delete((java.lang.String) map.get("CategoryPrimaryKey")); /* Deleting refrenced data */
            productRepository.delete((java.lang.String) map.get("ProductPrimaryKey")); /* Deleting refrenced data */
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

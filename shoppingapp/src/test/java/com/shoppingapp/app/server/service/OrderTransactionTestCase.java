package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.OrderTransactionRepository;
import com.shoppingapp.app.shared.onlineshopping.OrderTransaction;
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
import com.shoppingapp.app.shared.onlineshopping.OrderMain;
import com.shoppingapp.app.server.repository.OrderMainRepository;
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
public class OrderTransactionTestCase {

    @Autowired
    private OrderTransactionRepository<OrderTransaction> ordertransactionRepository;

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
            OrderMain ordermain = new OrderMain();
            ordermain.setGrandTotal(12.34);
            ordermain.setOrderDate(new java.sql.Date(123456789));
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("hZjLKo2LyRupSQgha1ejNX2x0y5pYRfh8HfEquY6iyKBNK0HhT");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2592);
            user.setUserAccessCode(5);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("HnfknVgGLtOjuHnSeBlh628fetaomw2PSReJOSjgjIQjVk6f3H");
            useraccessdomain.setDomainHelp("wueSUgSmPeyMVTyWzg7yvgKQYh9xRObTcpk6heNadDVKrHrpOI");
            useraccessdomain.setDomainIcon("FveJ0UuDmkgWnXgCVEDK81CpN3YMuTMIEjtcZNeKhf0rfkB6de");
            useraccessdomain.setDomainName("0EVzwSaCYU0JMZ3RONMQy588KAJpFL49Il9sy7RTkOI7vqKfmJ");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("oTOp9ZsGZ4V6OsVAPUWJ8McCPpCmtafxNaa82n0VGTywPHS5kv");
            useraccesslevel.setLevelHelp("EP9OUOXiTHZmtD5JKVvU3OlCFAWopSLvEq1fn2RNBkQDcXYRmW");
            useraccesslevel.setLevelIcon("ugCk03aVLM1n5UpP7oFkQYnRf0YcnIKyHHqZHEcqqZ0mZqWUT1");
            useraccesslevel.setLevelName("o4BDFtPOCn3WbeVwipP6coDNoQvKo0uqmSZ7IQNP3KyXfYGoVw");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("1K44p60l5BNhphV8CMeWMIXuyWVhakUMjFtLvjK7Qgo6XRnKpL");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1689);
            user.setUserAccessCode(3);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("4O88q1pMKEZj2yVUMVHjqhxcUSs2wXGsO8xd961kLFwzahAuxi");
            Question question = new Question();
            question.setLevelid(5);
            question.setQuestion("OTksiBnjhuRWvHeHK2rzAwtyBQsDtyHIkK2XxdEhudVyacI4Ec");
            question.setQuestionDetails("Y");
            question.setQuestionIcon("z9oJ9w0b8Ba7VDVPlva4cB92kNOD6OjpV5tGZpOaEnBLtzBQ23");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("0OmJDwyNnrQ0JBVEuQZocHEYknmCG0lgkhYR44Kcf7Ut0lKofQ");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("IpNEOTKSn0SNikZVCbdAS9kEHSRV3a42p4BihCP2kRLxGwsjcM");
            userdata.setOneTimePassword("BeUOGsX1JPr77AvCNGVX7EedArx8SgSK");
            userdata.setOneTimePasswordExpiry(5);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("yj7mjmG2XFP3xoyNqUcdBKTpemnTx3be9N11Zg4MMNZEqHLEVP");
            userdata.setLast5Passwords("GG8WHy5BnDf2Nr78oDPOcMkhU8Sux0klBWQ59scPFr8st9Pkzy");
            userdata.setOneTimePassword("ZAWtVZMTPW9bqRSFkzWzdmVuGQb8mvBi");
            userdata.setOneTimePasswordExpiry(3);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("JGYAwKxJx6lc1BEk9poJ5h4IDv4ngVAEtlsR6KfPYqlk0ABpDK");
            userdata.setUser(user);
            user.setUserData(userdata);
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            ordermain.setGrandTotal(12.34);
            ordermain.setOrderDate(new java.sql.Date(123456789));
            ordermain.setUserId((java.lang.String) UserTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<OrderDetails> listOfOrderDetails = new java.util.ArrayList<OrderDetails>();
            OrderDetails orderdetails = new OrderDetails();
            Item item = new Item();
            Brand brand = new Brand();
            brand.setBrandName("rXAqHvrmPofBABFbMqyVkrybrwvx2MK9C3blQ9yCEN5PN0dbK4");
            Category category = new Category();
            category.setCategoryName("RBKMUgdgEkBtSJ4belyUHqR3ieoVKvTjOamzQGpoLlJ5YCRMmb");
            Product product = new Product();
            product.setProductName("FZ3gfxJRVKxgflgrt0G9hzurL5gCvnBXv59GK2qBhUxYcVauP3");
            Product ProductTest = productRepository.save(product);
            map.put("ProductPrimaryKey", product._getPrimarykey());
            category.setCategoryName("5hGRYO1DsJeJk7uAdoQfHquQnkPjI5UgKpcna0aQ30tZSeQp7H");
            category.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Category CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
            brand.setBrandName("1AitjKWyhMjAqBCpSjJWjC6w6VGepkEyOmy638FimXSHLKPkok");
            brand.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            brand.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Brand BrandTest = brandRepository.save(brand);
            map.put("BrandPrimaryKey", brand._getPrimarykey());
            item.setBrandId((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setItemIcon("X");
            item.setItemName("HCIM4dD7CVFjcZgsy4KElgkoN5aCKOn8sWurwQeku8t3ZSSqZP");
            item.setItemPrice(12.34);
            item.setItemStock(775205210);
            item.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Item ItemTest = itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
            orderdetails.setItemId((java.lang.String) ItemTest._getPrimarykey()); /* ******Adding refrenced table data */
            orderdetails.setItemPrice(12.34);
            orderdetails.setItemQuantity(692601142);
            orderdetails.setOrderMain(ordermain);
            orderdetails.setSubTotal(12.34);
            listOfOrderDetails.add(orderdetails);
            ordermain.addAllOrderDetails(listOfOrderDetails);
            OrderMain OrderMainTest = ordermainRepository.save(ordermain);
            map.put("OrderMainPrimaryKey", ordermain._getPrimarykey());
            OrderTransaction ordertransaction = new OrderTransaction();
            ordertransaction.setOrderId((java.lang.String) OrderMainTest._getPrimarykey());
            ordertransaction.setTransactionId("T2G4TBiNTvLFpIGmnmfnCME7vLoougNYBaoBsUW2rMg3mMeiYL");
            ordertransaction.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            ordertransaction.setEntityValidator(entityValidator);
            ordertransaction.isValid();
            ordertransactionRepository.save(ordertransaction);
            map.put("OrderTransactionPrimaryKey", ordertransaction._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private OrderMainRepository<OrderMain> ordermainRepository;

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
            org.junit.Assert.assertNotNull(map.get("OrderTransactionPrimaryKey"));
            OrderTransaction ordertransaction = ordertransactionRepository.findById((java.lang.String) map.get("OrderTransactionPrimaryKey"));
            ordertransaction.setTransactionId("JsdSeyZEPArJvlPBWWVa149J7WWI0CRFdrZpOa0fL8o5hqinPo");
            ordertransaction.setVersionId(1);
            ordertransaction.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            ordertransactionRepository.update(ordertransaction);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByorderId() {
        try {
            java.util.List<OrderTransaction> listoforderId = ordertransactionRepository.findByOrderId((java.lang.String) map.get("OrderMainPrimaryKey"));
            if (listoforderId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("OrderTransactionPrimaryKey"));
            ordertransactionRepository.findById((java.lang.String) map.get("OrderTransactionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderTransactionPrimaryKey"));
            ordertransactionRepository.delete((java.lang.String) map.get("OrderTransactionPrimaryKey")); /* Deleting refrenced data */
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

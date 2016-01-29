package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.CartRepository;
import com.shoppingapp.app.shared.onlineshopping.Cart;
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
import com.shoppingapp.app.shared.onlineshopping.Item;
import com.shoppingapp.app.server.repository.ItemRepository;
import com.shoppingapp.app.shared.onlineshopping.Brand;
import com.shoppingapp.app.server.repository.BrandRepository;
import com.shoppingapp.app.shared.onlineshopping.Category;
import com.shoppingapp.app.server.repository.CategoryRepository;
import com.shoppingapp.app.shared.onlineshopping.Product;
import com.shoppingapp.app.server.repository.ProductRepository;
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
public class CartTestCase {

    @Autowired
    private CartRepository<Cart> cartRepository;

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
            Item item = new Item();
            Brand brand = new Brand();
            brand.setBrandName("xtU8iu1p8r77K3JA8Yq6i5eFgX8WNGAG97kT9fyqFWejt2JmIa");
            Category category = new Category();
            category.setCategoryName("3td0XKFGsx2b664aM5gc3ctlOi5MHnU9YU9wpaQt7XAissmTbP");
            Product product = new Product();
            product.setProductName("PqYBsHoVN3El7dkNDYcV8sCOBMIpd2v5jVJ0eEtu3rZgeUaKCB");
            Product ProductTest = productRepository.save(product);
            map.put("ProductPrimaryKey", product._getPrimarykey());
            category.setCategoryName("V0i0iN80ZQ8oJ4zGMVQ0QZrZiH8nmLZbQEfZKeGlT2b0Snyvri");
            category.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Category CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
            brand.setBrandName("mxX6XBLeT9zWhUmEMSMZGRT9gzO3yP5NZD09G4Q2bY06dExL30");
            brand.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            brand.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Brand BrandTest = brandRepository.save(brand);
            map.put("BrandPrimaryKey", brand._getPrimarykey());
            item.setBrandId((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setItemIcon("P");
            item.setItemName("sK2szJryIYLYF1mldRWdT7KbrkNc1G7zAdtrj8xFPWxmbyTijN");
            item.setItemPrice(12.34);
            item.setItemStock(758525025);
            item.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Item ItemTest = itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("9CYm4vFEMGfXK1zRajLWYoEdKFLq859f6u056UHGRSD9os0nQ3");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1899);
            user.setUserAccessCode(3);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("bYyFSv39DE13ld46StywMvnau86oZg7lAPuTWcnE2P94MAtiHF");
            useraccessdomain.setDomainHelp("AitGtM0609qToLtuWgcrzTrRo0EU3f7eoaQcTdpwpqBOtRzVr8");
            useraccessdomain.setDomainIcon("KW9p95hXq7E8EnHYGhHi6HqEali4ArhVrPdde2vXXBucoGqfk8");
            useraccessdomain.setDomainName("TwCrlBk33SVJdtGbaRyh5Cnr1Ogayn3Jsu5flXkhEuRjxmFOoy");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("1rg8V2H3rivNNCPdxyAzxO3rkKuVegkKhAr5f0GCXmZEMj8Ejc");
            useraccesslevel.setLevelHelp("QlaeyYA5WmJyqbaQ2ijPFL8ZrKmEQd4AOm6twCAs8T7idXPiu7");
            useraccesslevel.setLevelIcon("YFl3NI5RBGr5fTWRXvhGVCNe7QDG1RjKpAA1nntyHazHkz09eg");
            useraccesslevel.setLevelName("UWhyiuR81jsyYdQfRl9HUcuY2XtFVFtTVJVZkxFNDo4YrWpcI1");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("k8j5cxwzDYESOrRWvZDaio6vfjb4xLYdup1RrRWRBXYbbJqPyY");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2176);
            user.setUserAccessCode(7);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("7Z05pgbaDkSlIdYK7viBmlkpwVJ2fxeU9dOmAcsAcGpayQWkg2");
            Question question = new Question();
            question.setLevelid(7);
            question.setQuestion("hNvuF70TM7R8qonAbAPt9wig0eNX9xZQj51yG3fxaFkb3MbhMr");
            question.setQuestionDetails("w");
            question.setQuestionIcon("WGVgcLkM9uCS9p0aNf9nVRJlqDuS1oHMogfaIduzNEwgLlDt1g");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("tq866i1fWPcN74XgZXh2AafyoU1ctsvaREDnbWuRYzoC0aNrqB");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("2T9DbN8H7hnPoBKiERyCIuVk3oeloyVihVHChyOfqMRHSuhmts");
            userdata.setOneTimePassword("aWXXHFsfuASQZjq0PVM69UWIuACz6KBX");
            userdata.setOneTimePasswordExpiry(11);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("q8Pg4lPsoXPjz67f1KW1BKdzU4OdD3aWoXsnFq4HYqvfaIeFiV");
            userdata.setLast5Passwords("5FdSc14lOAv23EnL4Kazq8EvkUeLYqHQcBKLkvNay2DyxphKYX");
            userdata.setOneTimePassword("BHAAeFu7iKXB2HvmclXcm3vODLIhShf4");
            userdata.setOneTimePasswordExpiry(0);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("E5fSckw8S3Rq8ec4o2ol0KOEup1NKP0e3363kw5Y5SHI6UOkmz");
            userdata.setUser(user);
            user.setUserData(userdata);
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            Cart cart = new Cart();
            cart.setItemId((java.lang.String) ItemTest._getPrimarykey()); /* ******Adding refrenced table data */
            cart.setItemPrice(12.34);
            cart.setItemQuantity(788371392);
            cart.setSubTotal(12.34);
            cart.setUserId((java.lang.String) UserTest._getPrimarykey());
            cart.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            cart.setEntityValidator(entityValidator);
            cart.isValid();
            cartRepository.save(cart);
            map.put("CartPrimaryKey", cart._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Autowired
    private BrandRepository<Brand> brandRepository;

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Autowired
    private ProductRepository<Product> productRepository;

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
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            Cart cart = cartRepository.findById((java.lang.String) map.get("CartPrimaryKey"));
            cart.setItemPrice(12.34);
            cart.setItemQuantity(880147892);
            cart.setSubTotal(12.34);
            cart.setVersionId(1);
            cart.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cartRepository.update(cart);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            cartRepository.findById((java.lang.String) map.get("CartPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByitemId() {
        try {
            java.util.List<Cart> listofitemId = cartRepository.findByItemId((java.lang.String) map.get("ItemPrimaryKey"));
            if (listofitemId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<Cart> listofuserId = cartRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            cartRepository.delete((java.lang.String) map.get("CartPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            itemRepository.delete((java.lang.String) map.get("ItemPrimaryKey")); /* Deleting refrenced data */
            brandRepository.delete((java.lang.String) map.get("BrandPrimaryKey")); /* Deleting refrenced data */
            categoryRepository.delete((java.lang.String) map.get("CategoryPrimaryKey")); /* Deleting refrenced data */
            productRepository.delete((java.lang.String) map.get("ProductPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}

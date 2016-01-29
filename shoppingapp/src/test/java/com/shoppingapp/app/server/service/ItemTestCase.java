package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.ItemRepository;
import com.shoppingapp.app.shared.onlineshopping.Item;
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
public class ItemTestCase {

    @Autowired
    private ItemRepository<Item> itemRepository;

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
            Brand brand = new Brand();
            brand.setBrandName("5XFDtWgvbeF6tsWIx2JVLhDPhlkhqtRP7blJt1Zm4yPbMKLI0O");
            Category category = new Category();
            category.setCategoryName("Gil9Bop0dg5f3WoEucdmjdLrsGV2l8zUoKIeZNxODAP7yncO4o");
            Product product = new Product();
            product.setProductName("KzLE4byBdZdchiW3EfJQMt6OrJSwt7m17c7OsnHSwF31gIFym0");
            Product ProductTest = productRepository.save(product);
            map.put("ProductPrimaryKey", product._getPrimarykey());
            category.setCategoryName("LAREdaJJRQDPrnSavkzMDzXr5pGHcTJ8U392MYFdEsuJ08UDsr");
            category.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Category CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
            brand.setBrandName("mrpE2wd5ERlAHVlWLjGJgNNmFc7gTsyPdXNPkUpachYIVHg8Ov");
            brand.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            brand.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
            Brand BrandTest = brandRepository.save(brand);
            map.put("BrandPrimaryKey", brand._getPrimarykey());
            Item item = new Item();
            item.setBrandId((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            item.setItemIcon("j");
            item.setItemName("6O9oOzXdNZufoRm1O2JAYNN0cD8bCoYP77PEIopQK75NKjcQ2s");
            item.setItemPrice(12.34);
            item.setItemStock(338461080);
            item.setProductId((java.lang.String) ProductTest._getPrimarykey());
            item.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            item.setEntityValidator(entityValidator);
            item.isValid();
            itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private BrandRepository<Brand> brandRepository;

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Autowired
    private ProductRepository<Product> productRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            Item item = itemRepository.findById((java.lang.String) map.get("ItemPrimaryKey"));
            item.setItemIcon("Z");
            item.setItemName("aNWSCi4RZjvfi6vqGijX7k443h7iCpVFuB7pelRKs2WAKkVcQQ");
            item.setItemPrice(12.34);
            item.setItemStock(142928242);
            item.setVersionId(1);
            item.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            itemRepository.update(item);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybrandId() {
        try {
            java.util.List<Item> listofbrandId = itemRepository.findByBrandId((java.lang.String) map.get("BrandPrimaryKey"));
            if (listofbrandId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycategoryId() {
        try {
            java.util.List<Item> listofcategoryId = itemRepository.findByCategoryId((java.lang.String) map.get("CategoryPrimaryKey"));
            if (listofcategoryId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            itemRepository.findById((java.lang.String) map.get("ItemPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByproductId() {
        try {
            java.util.List<Item> listofproductId = itemRepository.findByProductId((java.lang.String) map.get("ProductPrimaryKey"));
            if (listofproductId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
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

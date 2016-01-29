package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.RolesRepository;
import com.shoppingapp.app.shared.authorization.Roles;
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
import com.shoppingapp.app.shared.authorization.RoleMenuBridge;
import com.shoppingapp.app.shared.authorization.AppMenus;
import com.shoppingapp.app.server.repository.AppMenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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
            roles.setRoleDescription("SVhK8EQjOP5vF1C7CHjbTe7kDPRkpKM3fqAtueFIOX1CUjFlHs");
            roles.setRoleHelp("8F7YWwtqkrPYp1jHH1FkvwVWVR1WOcbdbIBmfDGxAnmHgNM8KL");
            roles.setRoleIcon("monFm7gEnyEGi5KtEh4x8vOUNs2ib48r1ciKthWxO5tj3MWubT");
            roles.setRoleName("jtngKcYNSuJEQ3u3bzrn414XF1v9V9hbbmNN6IJl8bECUe4l1P");
            java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
            RoleMenuBridge rolemenubridge = new RoleMenuBridge();
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("Lq1oWciOVkjcQXKeYEYLim1yd1xL9xZzctue0SKAWEg7anl6bJ");
            appmenus.setAppType(2);
            appmenus.setAutoSave(true);
            appmenus.setMenuAccessRights(9);
            appmenus.setMenuAction("OPIuesh1hE1yVtIGmrAFosw0cIn95kLFim4xqDyrj5o6oxebrn");
            appmenus.setMenuCommands("AtsMEP3h4Dqikixh9lCbH4Vlp7dmxfyWaS7ppUVAt7BcteTsjQ");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("OEB5o6X9PP7OPyZ0cy38RjQVMCiGU6357ExaNm7EzWFp0ZgHpF");
            appmenus.setMenuLabel("88tUezPge1eFoaE3UOAELCbo0MMNErN1pl9XlRtpMRxPm66OCu");
            appmenus.setMenuTreeId("13xBwpSwReG62qCEu5nttUDOABpjQC7bBZ5XvQmFKgVVOprSsc");
            appmenus.setRefObjectId("IZDy4jxOwdEzyTEykQXIdwCim0NlICm8B9d3bC4inZDhYZsivX");
            appmenus.setUiType("hF9");
            AppMenus AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
            rolemenubridge.setRoles(roles);
            listOfRoleMenuBridge.add(rolemenubridge);
            roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.setEntityValidator(entityValidator);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleDescription("EhWyUfdt6EabLXX0ZVvUfKOu336frkXpCD4DPN8y1oLDXXbARk");
            roles.setRoleHelp("0NmmemgrXBa25yPjRBYfmLjobR8JhNmoha1I1xxytnTgUtMrE7");
            roles.setRoleIcon("pUZ0TfImUgGTLX4IoUm8EyCXrh8oIvHFUJXd5VcTqotC0XgjMz");
            roles.setRoleName("37ler7MY0PkLKxvrBYwT46kgKXrYW5AFHv1k5FdMZDXVV0M7z1");
            roles.setVersionId(1);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}

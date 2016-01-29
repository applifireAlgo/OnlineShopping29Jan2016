package com.shoppingapp.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shoppingapp.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shoppingapp.app.server.repository.AppMenusRepository;
import com.shoppingapp.app.shared.authorization.AppMenus;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppMenusTestCase {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("P3FbXV6trGUxUEdLEakL2HXcPZnsn3IBHp39FafLqiuuc29wgn");
            appmenus.setAppType(2);
            appmenus.setAutoSave(true);
            appmenus.setMenuAccessRights(11);
            appmenus.setMenuAction("SlPMUe3Yn5wkVYWckDSAOfk6POrzuwMODCyqRF7qxQZ9GoAG74");
            appmenus.setMenuCommands("2e9a82voquVLmX2etADaCpHVSVl6EBA1BeZhHY079voylzSmEh");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("2m0dQqB1hJJrz5phlc8C9EM79nB4rYXkZcSMTSKRz3lKuf8eBo");
            appmenus.setMenuLabel("2wnHT7b8PEVOmHLc4L6BUwbdQGjPOZYeRLuWfNf15Obe3beB9s");
            appmenus.setMenuTreeId("xBbZQkbFYFDkwGDVSFUA7eQiDSO3oABr0DQP65vUjaco7Jx4S2");
            appmenus.setRefObjectId("PcP5r3t9VPmJPusJ572dj1dOux0urIsIsHueDy5mbdNHCjy3j9");
            appmenus.setUiType("H2J");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.setEntityValidator(entityValidator);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setAppId("unyLeCJvtHCMozhJYvFEsfbfc0JMQVSiD0AM6odA4qSFyoWucv");
            appmenus.setAppType(2);
            appmenus.setMenuAccessRights(0);
            appmenus.setMenuAction("sxAvuL8oWiY9eQATWoFSVcbn2r3w3FaZ5MYrWvJxKRjNXQYHjr");
            appmenus.setMenuCommands("kCn6SkOwbmsv3tse7Y1yjXFD7DsMlexOCq0v9LiI8cLF1PCZLP");
            appmenus.setMenuIcon("5oAa46YgcrxbodQO7EKTpJcoSwOnJ8xilQ41X0Jv3EeUm89elM");
            appmenus.setMenuLabel("p6hFtJJXYD2gznVQqn4FqTq8ohdhknyqVu8McMHuEkXJZ5v7oq");
            appmenus.setMenuTreeId("8HeU5Y4T26wRHKIflCJhKSCYo9nDIhmIDa2uprWuED9XTKkF8J");
            appmenus.setRefObjectId("vlQZKp0iRvZDgGHY20hOmlyYakWYKaSNYVGkYmfEesTzWzXfbT");
            appmenus.setUiType("BiK");
            appmenus.setVersionId(1);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}

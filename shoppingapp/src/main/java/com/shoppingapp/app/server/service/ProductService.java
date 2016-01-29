package com.shoppingapp.app.server.service;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.http.HttpEntity;
import com.athena.framework.server.exception.repository.SpartanTransactionException;
import com.shoppingapp.app.shared.onlineshopping.Product;
import java.util.List;
import java.util.Map;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Service for Product Master table Entity", complexity = Complexity.LOW)
public abstract class ProductService {

    public HttpEntity<ResponseBean> findAll() throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(Product entity) throws Exception, SpartanTransactionException, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Product> entity, boolean isArray) throws Exception, SpartanTransactionException, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Product entity) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Product> entity, boolean isArray) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }
}

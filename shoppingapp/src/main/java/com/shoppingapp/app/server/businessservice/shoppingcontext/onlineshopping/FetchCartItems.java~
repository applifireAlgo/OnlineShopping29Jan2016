package com.shoppingapp.app.server.businessservice.shoppingcontext.onlineshopping;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.shoppingapp.app.server.repository.CartRepository;
import com.shoppingapp.app.shared.onlineshopping.Cart;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanUnableToProcessException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;

@Component
public class FetchCartItems {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private CartRepository<Cart> cartRepository;

    @Autowired
    private SessionDataMgtService sessionService;

    public List<Cart> fetchCartItems() throws SpartanPersistenceException, SpartanUnableToProcessException, SpartanDataNotFoundException, Exception {
        java.lang.String userIdFromSession = (java.lang.String) sessionService.getSessionData("userId");
        if (userIdFromSession == null) {
            throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
        }
        java.util.List<com.shoppingapp.app.shared.onlineshopping.Cart> cartList = cartRepository.findByUserId(userIdFromSession);
        return cartList;
    }
}

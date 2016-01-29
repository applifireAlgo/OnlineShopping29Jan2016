package com.shoppingapp.app.server.businessservice.shoppingcontext.onlineshopping;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.shoppingapp.app.server.businessservice.OrderProcessServiceImpl;
import com.shoppingapp.app.server.repository.CartRepository;
import com.shoppingapp.app.server.repository.ItemRepository;
import com.shoppingapp.app.server.repository.OrderMainRepository;
import com.shoppingapp.app.server.repository.OrderTransactionRepository;
import com.shoppingapp.app.shared.onlineshopping.Cart;
import com.shoppingapp.app.shared.onlineshopping.Item;
import com.shoppingapp.app.shared.onlineshopping.OrderMain;
import com.shoppingapp.app.shared.onlineshopping.OrderTransaction;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import com.shoppingapp.app.shared.shoppingcontext.onlineshopping.PaymentDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderProcessingService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private OrderMainRepository<OrderMain> orderMainRepository;

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Autowired
    private CartRepository<Cart> cartRepository;

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private OrderProcessServiceImpl orderProcessServiceImpl;

    @Autowired
    private OrderTransactionRepository<OrderTransaction> orderTransactionRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void processOrder(PaymentDetails paymentDetails) throws SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException, Exception {
        java.lang.String userIdFromSession = (java.lang.String) sessionService.getSessionData("userId");
        if (userIdFromSession == null) {
            throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
        }
        if (paymentDetails.getAmount() <= 0) {
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3009");
        }
        java.util.List<com.shoppingapp.app.shared.onlineshopping.Cart> cartList = cartRepository.findByUserId(userIdFromSession);
        com.shoppingapp.app.shared.shoppingcontext.acl.OrderACL orderACL = new com.shoppingapp.app.shared.shoppingcontext.acl.OrderACL(cartList);
        com.shoppingapp.app.shared.onlineshopping.OrderMain orderMain1 = orderMainRepository.save(orderACL.getOrder());
        com.shoppingapp.app.shared.shoppingcontext.onlineshopping.TransactionResponse transactionresponse1 = orderProcessServiceImpl.processOrder(paymentDetails);
        com.shoppingapp.app.shared.onlineshopping.OrderTransaction orderTransaction1 = new com.shoppingapp.app.shared.onlineshopping.OrderTransaction();
        orderTransaction1.setOrderId(orderMain1.getOrderId());
        orderTransaction1.setTransactionId(transactionresponse1.getTransactionId());
        orderMain1.setOrderDate(new java.sql.Date(java.lang.System.currentTimeMillis()));
        orderMain1.setUserId(runtimeLogInfoHelper.getRuntimeLogInfo().getUserId());
        orderMain1.setGrandTotal(orderMain1.getTotalSubTotal());
        for (com.shoppingapp.app.shared.onlineshopping.Cart cartListElement : cartList) {
            if (cartListElement.getItemId() != null) {
                com.shoppingapp.app.shared.onlineshopping.Item item = itemRepository.findById(cartListElement.getItemId());
                item.setItemStock(item.getItemStock() - cartListElement.getItemQuantity());
                cartListElement.getSystemInfo().setActiveStatus(0);
                itemRepository.update(item);
                cartRepository.update(cartList);
            }
        }
        com.shoppingapp.app.shared.onlineshopping.OrderTransaction orderTransaction2 = orderTransactionRepository.save(orderTransaction1);
        orderMainRepository.update(orderMain1);
    }
}

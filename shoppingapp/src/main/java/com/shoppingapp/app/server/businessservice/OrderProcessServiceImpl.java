package com.shoppingapp.app.server.businessservice;
import org.springframework.stereotype.Service;
import com.athena.deo.camel.utility.ExternalIntegrationCaller;
import org.springframework.beans.factory.annotation.Autowired;
import com.shoppingapp.app.shared.shoppingcontext.onlineshopping.PaymentDetails;
import com.shoppingapp.app.shared.shoppingcontext.onlineshopping.TransactionResponse;

@Service
public class OrderProcessServiceImpl {

    @Autowired
    private ExternalIntegrationCaller externalIntegrationCaller;

    public TransactionResponse processOrder(PaymentDetails paymentDetails) throws Exception {
        try {
            java.util.HashMap map = new java.util.HashMap();
            map.put("paymentDetails", paymentDetails);
            com.shoppingapp.app.shared.shoppingcontext.onlineshopping.TransactionResponse transactionresponse = (com.shoppingapp.app.shared.shoppingcontext.onlineshopping.TransactionResponse) externalIntegrationCaller.executeRoute("ADFEEABE-5414-42C9-9DD2-E86AC82AAB03", map);
            return transactionresponse;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

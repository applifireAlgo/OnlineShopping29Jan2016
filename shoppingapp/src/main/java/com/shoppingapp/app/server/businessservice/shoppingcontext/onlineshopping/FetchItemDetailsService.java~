package com.shoppingapp.app.server.businessservice.shoppingcontext.onlineshopping;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.shoppingapp.app.server.businessservice.shoppingcontext.FetchItemDetailsBzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanUnableToProcessException;
import com.shoppingapp.app.shared.shoppingcontext.FetchItemDetails;
import java.util.List;

@Component
public class FetchItemDetailsService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private FetchItemDetailsBzService fetchItemDetailsBzService;

    public List<FetchItemDetails> fetchItemDetails() throws SpartanUnableToProcessException, Exception {
        java.util.List<com.shoppingapp.app.shared.shoppingcontext.FetchItemDetails> fetchItemDetailsList1 = fetchItemDetailsBzService.executeQueryFetchItemDetails();
        return fetchItemDetailsList1;
    }
}

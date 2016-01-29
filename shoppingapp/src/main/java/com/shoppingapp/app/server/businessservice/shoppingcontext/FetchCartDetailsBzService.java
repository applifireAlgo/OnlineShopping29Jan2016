package com.shoppingapp.app.server.businessservice.shoppingcontext;
import com.shoppingapp.app.shared.shoppingcontext.FetchCartDetails;
import java.util.List;

public interface FetchCartDetailsBzService {

    public List<FetchCartDetails> executeQueryFetchCartDetails(String userId1) throws Exception;
}

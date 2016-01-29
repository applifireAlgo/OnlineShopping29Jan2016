package com.shoppingapp.app.server.businessservice.shoppingcontext;
import com.shoppingapp.app.shared.shoppingcontext.FetchItemDetails;
import java.util.List;

public interface FetchItemDetailsBzService {

    public List<FetchItemDetails> executeQueryFetchItemDetails() throws Exception;
}

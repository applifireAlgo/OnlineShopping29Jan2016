package com.shoppingapp.app.server.businessservice.shoppingcontext;
import org.springframework.stereotype.Component;
import com.athena.server.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.shoppingapp.app.shared.shoppingcontext.FetchItemDetails;
import java.lang.Override;
import java.util.List;

@Component
public class FetchItemDetailsBzServiceImpl implements FetchItemDetailsBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<FetchItemDetails> executeQueryFetchItemDetails() throws Exception {
        java.util.List<com.shoppingapp.app.shared.shoppingcontext.FetchItemDetails> listDtoInterface = new java.util.ArrayList<com.shoppingapp.app.shared.shoppingcontext.FetchItemDetails>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "FFF92B1D-45BD-42BE-99CF-40F4F297D12C");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.shoppingapp.app.shared.shoppingcontext.FetchItemDetails", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}

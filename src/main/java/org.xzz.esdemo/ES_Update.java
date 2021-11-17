package org.xzz.esdemo;


import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.xzz.esdemo.util.ES_Client_Util;

import java.io.IOException;

public class ES_Update {
    public static void main(String[] args) {
        RestHighLevelClient esClient = ES_Client_Util.getESClient();
        UpdateRequest updateRequest=new UpdateRequest();
        updateRequest.index("user").id("1000");
        updateRequest.doc(XContentType.JSON, "sex", "男","name","张三");
        UpdateResponse response = null;
        try {
            response = esClient.update(updateRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println(response.getResult());
            ES_Client_Util.close(esClient);
        }


    }
}

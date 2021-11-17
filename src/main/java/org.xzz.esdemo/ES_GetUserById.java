package org.xzz.esdemo;


import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.xzz.esdemo.util.ES_Client_Util;

import java.io.IOException;

/**
 * @author Administrator
 */
public class ES_GetUserById {
    public static void main(String[] args) {
        RestHighLevelClient esClient = ES_Client_Util.getESClient();
        // 查询数据
        GetRequest request = new GetRequest();
        request.index("user").id("1000");
        GetResponse response = null;
        try {
            response = esClient.get(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println(response.getSourceAsString());
            ES_Client_Util.close(esClient);
        }

    }
}

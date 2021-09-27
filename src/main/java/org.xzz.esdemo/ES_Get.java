package main.java.org.xzz.esdemo;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

public class ES_Get {
    public static void main(String[] args) {
        //获取es客户端
        RestHighLevelClient esClient = ES_Client_Util.getESClient();
       GetIndexRequest getIndexRequest=new GetIndexRequest("index_test_user");
        try {
            GetIndexResponse getIndexResponse=esClient.indices().get(getIndexRequest,RequestOptions.DEFAULT);
            System.out.println(getIndexResponse);
            System.out.println(getIndexResponse.getAliases());
            System.out.println(getIndexResponse.getMappings());
            System.out.println(getIndexResponse.getSettings());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ES_Client_Util.close(esClient);
        }

    }
}

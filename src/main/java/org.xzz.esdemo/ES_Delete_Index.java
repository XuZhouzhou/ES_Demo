package main.java.org.xzz.esdemo;


import main.java.org.xzz.esdemo.util.ES_Client_Util;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ES_Delete_Index {
    public static void main(String[] args) {
        //获取es客户端
        RestHighLevelClient esClient = ES_Client_Util.getESClient();
        DeleteIndexRequest deleteIndexRequest=new DeleteIndexRequest("index_test_user");
        try {
            AcknowledgedResponse acknowledgedResponse=esClient.indices().delete(deleteIndexRequest,RequestOptions.DEFAULT);
            // 响应状态
            System.out.println(acknowledgedResponse.isAcknowledged());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ES_Client_Util.close(esClient);
        }

    }
}

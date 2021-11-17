package org.xzz.esdemo;

import main.java.org.xzz.esdemo.util.ES_Client_Util;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ES_Creat_Index {
    public static void main(String[] args) {
        //获取es客户端
        RestHighLevelClient esClient= ES_Client_Util.getESClient();
        //创建索引
        CreateIndexRequest request = new CreateIndexRequest("user");

        //响应
        CreateIndexResponse createIndexResponse = null;
        try {
            //创建索引 响应
            createIndexResponse = esClient.indices().create(request, RequestOptions.DEFAULT);
            // 响应状态
            boolean acknowledged = createIndexResponse.isAcknowledged();
            System.out.println("索引操作 ：" + acknowledged);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           ES_Client_Util.close(esClient);
        }

    }
}

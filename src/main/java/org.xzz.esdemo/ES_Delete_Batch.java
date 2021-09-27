package main.java.org.xzz.esdemo;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ES_Delete_Batch {
    public static void main(String[] args) {
        RestHighLevelClient esClient = ES_Client_Util.getESClient();
        //批量删除
        BulkRequest bulkRequest=new BulkRequest();
        bulkRequest.add(new DeleteRequest().index("user").id("1001"));
        bulkRequest.add(new DeleteRequest().index("user").id("1002"));
        bulkRequest.add(new DeleteRequest().index("user").id("1003"));
        BulkResponse response = null;
        try {
            response = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println(response.getTook());
            System.out.println(response.getItems().toString());
            ES_Client_Util.close(esClient);
        }

    }
}

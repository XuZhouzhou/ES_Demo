package main.java.org.xzz.esdemo;


import main.java.org.xzz.esdemo.util.ES_Client_Util;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ES_DeleteUserByid {
    public static void main(String[] args) {
        RestHighLevelClient esClient = ES_Client_Util.getESClient();
        DeleteRequest deleteRequest=new DeleteRequest();
        deleteRequest.index("user").id("1000");
        try {
            DeleteResponse deleteResponse=esClient.delete(deleteRequest, RequestOptions.DEFAULT);
            System.out.println(deleteResponse.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ES_Client_Util.close(esClient);
        }
    }
}

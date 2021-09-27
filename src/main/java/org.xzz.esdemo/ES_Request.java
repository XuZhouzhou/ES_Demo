package main.java.org.xzz.esdemo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ES_Request {
    private static String ip="localhost";
    private static int port=9200;
    private static String reastType="http";
    public static RestHighLevelClient getESClient() {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(ip, 9200, reastType)));
        return  client;
    }
    public static void  close( RestHighLevelClient client ){
        try {
            client.close();
        } catch (IOException e) {
            //异常抛出 流关闭
            e.printStackTrace();
        }
    }
}

package main.java.org.xzz.esdemo;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class Es_Insert_Batch {
    public static void main(String[] args) {
        RestHighLevelClient esClient = ES_Client_Util.getESClient();
        // 批量插入数据
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "苏妲己", "age",30,"sex","女"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "杨贵妃", "age",30,"sex","女"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "貂蝉", "age",40,"sex","女"));
        request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "周瑜", "age",40,"sex","男"));
        BulkResponse response = null;
        try {
            response = esClient.bulk(request, RequestOptions.DEFAULT);
            System.out.println(response.getTook());
            System.out.println(response.getItems());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ES_Client_Util.close(esClient);
        }

    }
}

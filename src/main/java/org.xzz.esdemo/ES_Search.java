package main.java.org.xzz.esdemo;

import main.java.org.xzz.esdemo.util.ES_Client_Util;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import java.io.IOException;
import java.util.Iterator;

public class ES_Search {
    public static void main(String[] args) {
        RestHighLevelClient esClient = ES_Client_Util.getESClient();
        // 1. 查询索引的所有数据
        SearchRequest request = new SearchRequest();
        request.indices("user");
        // 构造查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.matchAllQuery());
        builder.from(0);
        builder.size(200);
        builder.sort("age", SortOrder.DESC);
        request.source(builder);
        SearchResponse response = null;
        try {
            response = esClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
//            System.out.println(response.getTook());
            System.out.println(hits.getTotalHits().value);
            Iterator<SearchHit> iterator = hits.iterator();
            while (iterator.hasNext()) {
                SearchHit hit = iterator.next();
                System.out.println(hit.getSourceAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ES_Client_Util.close(esClient);
        }

    }
}

package org.xzz.esdemo;


import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.xzz.esdemo.util.ES_Client_Util;

import java.io.IOException;

public class ES_Query {
    public static void main(String[] args) {
        RestHighLevelClient esClient = ES_Client_Util.getESClient();
        // 1. 查询索引中全部的数据
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //以下两个参数用于分页  from  从第几个开始   size  每页多少个数据
//        //计算方式 （起始页*每页页数）-1
//        query.from(0);
//        query.size(2000);
//        request.source(query);
//        SearchResponse response = null;
//        try {
//            response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for ( SearchHit hit : hits ) {
//                System.out.println(hit.getSourceAsString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        // 2. 条件查询 : termQuery
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 18)));
//        SearchResponse response = null;
//        try {
//            response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for ( SearchHit hit : hits ) {
//                System.out.println(hit.getSourceAsString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        // 3. 分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        // (当前页码-1)*每页显示数据条数
//        builder.from(2);
//        builder.size(2);
//        request.source(builder);
//        SearchResponse response = null;
//        try {
//            response = esClient.search(request, RequestOptions.DEFAULT);
//
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for ( SearchHit hit : hits ) {
//                System.out.println(hit.getSourceAsString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        // 4. 查询排序
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //
//        builder.sort("age", SortOrder.DESC);
//
//        request.source(builder);
//        SearchResponse response = null;
//        try {
//            response = esClient.search(request, RequestOptions.DEFAULT);
//
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for ( SearchHit hit : hits ) {
//                System.out.println(hit.getSourceAsString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        // 5. 过滤字段
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //
//        String[] excludes = {"age"};
//        String[] includes = {};
//        builder.fetchSource(includes, excludes);
//
//        request.source(builder);
//        SearchResponse response = null;
//        try {
//            response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for ( SearchHit hit : hits ) {
//                System.out.println(hit.getSourceAsString());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        // 6. 组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("age", 30));
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("sex", "男"));
//        //boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex", "男"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 30));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 40));
//
//        builder.query(boolQueryBuilder);
//
//        request.source(builder);
//        SearchResponse response = null;
//        try {
//            response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for ( SearchHit hit : hits ) {
//                System.out.println(hit.getSourceAsString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        // 7. 范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//
//        rangeQuery.gte(30);
//        rangeQuery.lt(50);
//
//        builder.query(rangeQuery);
//
//        request.source(builder);
//        SearchResponse response = null;
//        try {
//            response = esClient.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//
//            System.out.println(hits.getTotalHits());
//            System.out.println(response.getTook());
//
//            for ( SearchHit hit : hits ) {
//                System.out.println(hit.getSourceAsString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        // 8. 模糊查询
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        //wildcardQuery 通配符查询 * ？ prefixQuery 前缀查询   fuzzyQuery 左右模糊查询
        builder.query(QueryBuilders.wildcardQuery("name", "*于*"));
        builder.from(0);
        builder.size(2000);
        request.source(builder);
        SearchResponse response = null;
        try {
            response = esClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();

            System.out.println(hits.getTotalHits());
            System.out.println(response.getTook());

            for ( SearchHit hit : hits ) {
                System.out.println(hit.getSourceAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



//        // 9. 高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name", "zhangsan");
//
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//
//        builder.highlighter(highlightBuilder);
//        builder.query(termsQueryBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for ( SearchHit hit : hits ) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 10. 聚合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//        builder.aggregation(aggregationBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for ( SearchHit hit : hits ) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 11. 分组查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
//        builder.aggregation(aggregationBuilder);
//
//        request.source(builder);
//        SearchResponse response = null;
//        try {
//            response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for ( SearchHit hit : hits ) {
//            System.out.println(hit.getSourceAsString());
//        } } catch (IOException e) {
//            e.printStackTrace();
//        }

      ES_Client_Util.close(esClient);

    }
}

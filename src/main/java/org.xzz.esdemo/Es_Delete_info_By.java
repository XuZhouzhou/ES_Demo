package main.java.org.xzz.esdemo;

import main.java.org.xzz.esdemo.util.ES_Client_Util;
import org.apache.lucene.search.TermQuery;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.Cancellable;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

public class Es_Delete_info_By {
    private static String index = "user";

    public static void main(String[] args) {
        BoolQueryBuilder must = QueryBuilders.boolQuery().must(termQuery("name.keyword", "谷梁捻"))
                ;
        //准备request对象
        DeleteByQueryRequest request =
                //在一组索引上创建DeleteByQueryRequest。
                new DeleteByQueryRequest("user");
        //设置版本冲突时继续
        request.setConflicts("proceed");
        //仅复制字段用户设置为kimchy的文档
        request.setQuery(must);
        //等待按查询删除请求作为时间值执行的超时
        request.setTimeout(TimeValue.timeValueMinutes(5));
        //调用查询删除后刷新索引
        request.setRefresh(true);
        //设置索引选项
        request.setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN);

        ES_Client_Util.getESClient().deleteByQueryAsync(request, RequestOptions.DEFAULT, new ActionListener<BulkByScrollResponse>() {
            @Override
            public void onResponse(BulkByScrollResponse bulkResponse) {
                //成功的时候调用
                System.out.println("成功");
            }

            @Override
            public void onFailure(Exception e) {
                //失败的时候调用
                System.out.println("失败");
            }
        });

    }

    private void deleteIndexInfo() {
        //准备request对象
        DeleteByQueryRequest request =
                //在一组索引上创建DeleteByQueryRequest。
                new DeleteByQueryRequest("user");
        request.setConflicts("proceed"); //设置版本冲突时继续
        request.setQuery(new TermQueryBuilder("age", 20)); //仅复制字段用户设置为kimchy的文档
        request.setTimeout(TimeValue.timeValueMinutes(5)); //等待按查询删除请求作为时间值执行的超时
        request.setRefresh(true); //调用查询删除后刷新索引
        request.setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN); //设置索引选项

        Cancellable cancellable = ES_Client_Util.getESClient().deleteByQueryAsync(request, RequestOptions.DEFAULT, new ActionListener<BulkByScrollResponse>() {
            @Override
            public void onResponse(BulkByScrollResponse bulkResponse) {
                //成功的时候调用
                System.out.println("成功");
            }

            @Override
            public void onFailure(Exception e) {
                //失败的时候调用
                System.out.println("失败");
            }
        });

    }
}

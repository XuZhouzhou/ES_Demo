package org.xzz.esdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.xzz.esdemo.util.ES_Client_Util;
import org.xzz.esdemo.util.UserUtil;

import java.io.IOException;

public class ES_Insert {
    public static void main(String[] args) {
        RestHighLevelClient esClient = ES_Client_Util.getESClient();

        User user = null;
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            for (int i = 0; i <= 10; i++) {
                //插入50条数据
                IndexRequest indexRequest=new IndexRequest();
                indexRequest.index("user").id(UserUtil.getfourNum());
                user = new User();
                user.setName(UserUtil.getChineseName());
                user.setAge(UserUtil.getAge());
                user.setSex(UserUtil.getSex());
               // user.setAccountNumber("asdasdasdas");
                String userJson = objectMapper.writeValueAsString(user);
                indexRequest.source(userJson, XContentType.JSON);
                IndexResponse response = esClient.index(indexRequest, RequestOptions.DEFAULT);
                System.out.println(response.getResult());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ES_Client_Util.close(esClient);
        }

    }
}

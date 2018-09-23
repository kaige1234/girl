package cn.com.ssm.Test.Elasticsearch;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class TestElasticsearch_01 {
    private static  Client client;
    static{
        try {
            client = TransportClient.builder().build().addTransportAddress(
                   new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9300)
           );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向Elasticsearch的文档中插入数据
     *
     */
    public static void insertDoc(){
        try {
            IndexResponse response = client.prepareIndex("sunkai","tow","3").setSource(
                    jsonBuilder().startObject()
                            .field("type","syslog01")
                            .field("eventCount",2)
                            .field("eventDate",new Date())
                            .field("message","secilog insert doc test")
                            .endObject()

            ).get();
            System.out.println("index:"+response.getIndex()+"insert doc id:"+response.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.close();
    }

    /**
     * 修改文档
     * 直接修改
     */
    public static void update() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("sunkai");
        updateRequest.type("tow");
        updateRequest.id("2");
        updateRequest.doc(
                jsonBuilder().startObject().field("type","sunkai").endObject()
        );
        try {
            client.update(updateRequest).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        client.close();
    }

    /**
     * 如果有就修改，没有就添加
     */
    public static void isUseUpdate(){
        try {
            IndexRequest indexRequest = new IndexRequest("sunkai","tow","3")
                    .source(
                            jsonBuilder()
                    .startObject()
                    .field("type","syslog")
                    .field("eventCount",2)
                    .field("eventDate",new Date())
                    .field("message","sunkai is strong")
                    .endObject()
                    );
            UpdateRequest updateRequest = new UpdateRequest("sunkai","tow","4")
                    .doc(jsonBuilder().startObject().field("type","file").endObject())
                    .upsert(indexRequest);
            client.update(updateRequest).get();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        client.close();
    }


    /**
     * 查询文档
     */
    public static void getDoc(){
        GetResponse response = client.prepareGet("sunkai","tow","3").get();
        String source =  response.getSource().toString();
        long version = response.getVersion();
        String indexName = response.getIndex();
        String type = response.getType();
        String id = response.getId();
        System.out.println("source:"+source+";");
        System.out.println("version:"+version+";");
        System.out.println("indexName:"+indexName+";");
        System.out.println("type:"+type+";");
        System.out.println("id:"+id+";");
        client.close();
    }


    /**
     * 删除文档
     */
    public static void delDoc(){
        DeleteResponse dresponse = client.prepareDelete("sunkai","tow","4").get();
        boolean isFound = dresponse.isFound();
        DeleteIndexRequest delete = new DeleteIndexRequest("sunkai");
        client.admin().indices().delete(delete);
        client.close();
    }


    public static void main(String[] args) throws UnknownHostException {
        //TestElasticsearch_01.insertDoc();

        /*try {
            TestElasticsearch_01.update();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        TestElasticsearch_01.isUseUpdate();

       // TestElasticsearch_01.getDoc();
        //TestElasticsearch_01.delDoc();
    }
}

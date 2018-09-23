package cn.com.ssm.Test.Elasticsearch;


import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

public class TestElasticsearch {
    public static void main(String[] args) throws IOException {
        Settings settings = Settings.settingsBuilder().put("secisland","secilog").build();
        Client client = TransportClient.builder().settings(settings).build();

        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject()
                .startObject("settings").field("number_of_shards",1)
                .field("number_of_replicas",0).endObject().endObject()
                .startObject().startObject("aaa").startObject("properties").startObject("type")
                .field("type","string").field("store","yes")
                .endObject().startObject("eventCount").field("type","long").field("store","yes")
                .endObject()
                .startObject("eventDate").field("type","date")
                .field("format","dateOptionalTime").field("store","yes")
                .endObject()
                .startObject("message").field("type","string")
                .field("index","not_analyzed").field("store","yes")
                .endObject().endObject().endObject().endObject();
        CreateIndexRequestBuilder cirb = client.admin().indices().prepareCreate("sssss")
                .setSource(mapping);
        CreateIndexResponse response = cirb.execute().actionGet();
        if(response.isAcknowledged()){
            System.out.println("dddsalfja");
        }

    }
}

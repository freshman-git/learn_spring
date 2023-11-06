package com.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpSender {

    public static int send(String url, HashMap<String,String> heads, String content) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        for (Map.Entry<String,String> entry:heads.entrySet()){
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println(response.toString());
        int statusCode = response.getStatusLine().getStatusCode();
        return statusCode;
    }
}

package com.example.demo.controller;

import com.example.demo.VO.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class WebTestController {

    @GetMapping("/findWeb")
    public ResponseResult linkWeb() throws IOException {

        URL url = new URL("http://www.baidu.com");

        HttpURLConnection httpURLConnection = new HttpURLConnection(url) {
            @Override
            public void connect() throws IOException {
            }

            @Override
            public void disconnect() {

            }

            @Override
            public boolean usingProxy() {
                return false;
            }
        };
        httpURLConnection.connect();
        return new ResponseResult(2000,"success",null);
    }
}

package com.test.jk.base.net;

import com.data.map.net.ZNetConnection;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;

public class NetTest {

    @Test
    void hangleTest(){
        String text ="";
    }


    @Test
    void findDataTest() throws Exception {
        System.out.println("[findDataTest] begin ------------------------------");
        ZNetConnection c = new ZNetConnection();
        //String url = URLEncoder.encode("https://www.inflearn.com/?utm_source=google_brand_search&utm_medium=cpc&utm_campaign=inflearn_%EC%9D%B8%EC%A7%80%EB%8F%84_%EB%B8%8C%EB%9E%9C%EB%93%9C_main&utm_content=%EB%A6%AC%ED%83%80%EA%B2%8C%ED%8C%85_%EC%A0%84%EC%B2%B4&utm_term=210803_%ED%83%80%EC%9D%B4%ED%8B%80_%EB%A9%94%EC%9D%B8_%EC%9C%8C&gclid=CjwKCAjw4ayUBhA4EiwATWyBron5vL74AUl5F-kqat0Fk4TE-i6Y47ngE1aZwkQAUKMLRej9u5PN-BoCiVIQAvD_BwE", "UTF-8");
        String url = "https://www.naver.com/";
        c.find(url);

        System.out.println("[findDataTest] end ------------------------------");
    }

    @Test
    void weatherDatas(){
        System.out.println("[weatherDatas] begin ------------------------------");
        ZNetConnection c = new ZNetConnection();
        String url = "https://weather.naver.com/today";
        c.find(url);

        System.out.println("[weatherDatas] end ------------------------------");
    }

}

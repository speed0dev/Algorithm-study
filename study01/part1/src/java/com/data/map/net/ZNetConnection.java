package com.data.map.net;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ZNetConnection {

    IAct act = null;        // 수집, 분석, 결과

    public ZNetConnection(){

    }

    public void setAct(IAct act){
        this.act = act;
    }

    public void find(String url){
        //
        Connection conn = Jsoup.connect(url);
        //conn.setConnectTimeout(3000);
        //conn.setUseCaches(true);

        try {
            //
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36")
                    .header("scheme", "https")
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("accept-encoding", "gzip, deflate, br")
                    .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
                    .header("cache-control", "no-cache")
                    .header("pragma", "no-cache")
                    .header("upgrade-insecure-requests", "1")
                    .get();

            //Document doc = conn.header("Accept", "image/gif, image/xxbitmap, image/jpeg, image/pjpeg,application/xshockwaveflash, application/vnd.msexcel,application/vnd.mspowerpoint, application/msword, */*").get();
            // findElement
            //Document doc = Jsoup.connect(url).get();
            doAct(doc);

            System.out.println(doc.text());
            //
            /*
            Elements els = doc.getElementsByClass("course_title"); //
            //Elements els = doc.select(".weather_area.summary.weather");
            for(Element e: els){
                System.out.println(new String(e.text().getBytes(), "UTF-8"));
            }
            */


        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void doAct(Document doc) {
        //action.excute(doc);
        if(act != null){
            //act(this); //
        }

    }


}

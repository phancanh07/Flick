package com.example.fickhd.presenters;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Contend extends AsyncTask<Void, Void, Void> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            String url = "http://www.xiuren.org/";

            Document doc = Jsoup.connect(url).get();

            Elements data = doc.select("div.loop");
            int size = data.size();
            Log.d("doc", "doc: " + doc);
            Log.d("data", "data: " + data);
            Log.d("size", "" + size);
//            for (int i = 0; i < size; i++) {
//                String imgUrl = data.select("span.thumbnail")
//                        .select("img")
//                        .eq(i)
//                        .attr("src");
//                Log.d("sizesdasdss", "" + imgUrl);
//                String title = data.select("h4.gridminfotitle")
//                        .select("span")
//                        .eq(i)
//                        .text();
//
//                String detailUrl = data.select("h4.gridminfotitle")
//                        .select("a")
//                        .eq(i)
//                        .attr("href");
//
////                parseItems.add(new ParseItem(imgUrl, title, detailUrl));
////                Log.d("items", "img: " + imgUrl + " . title: " + title);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
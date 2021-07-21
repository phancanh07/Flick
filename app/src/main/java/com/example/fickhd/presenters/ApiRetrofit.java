package com.example.fickhd.presenters;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {
    //https://canhwallpaper.herokuapp.com/getlist
    //https://www.flickr.com/services/rest/?method=flickr.favorites.getList&api_key=14c2d7ab479117745022e93c2474fbb9&user_id=192962387%40N04&extras=description%2C+license%2C+date_upload%2C+date_taken%2C+owner_name%2C+icon_server%2C+original_format%2C+last_update%2C+geo%2C+tags%2C+machine_tags%2C+o_dims%2C+views%2C+media%2C+path_alias%2C+url_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_c%2C+url_l%2C+url_o&per_page=100&format=json&nojsoncallback=1
    private static Retrofit retrofit = null;
    private static Retrofit retrofit1 = null;
    public static final String BASE_URL = "https://www.flickr.com/";
    public static final String BASE_URL_WALL = "https://canhwallpaper.herokuapp.com/";
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
    public static Retrofit getClientWall() {
        if (retrofit1 == null) {
            retrofit1 = new Retrofit.Builder()
                    .baseUrl(BASE_URL_WALL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit1;
    }
}

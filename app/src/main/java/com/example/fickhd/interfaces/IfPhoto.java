package com.example.fickhd.interfaces;

import com.example.fickhd.model.PhotoBg;
import com.example.fickhd.model.Photos;
import com.example.fickhd.model.Wallpaper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IfPhoto {
    //http://jsonviewer.stack.hu/#https://www.flickr.com/services/rest/?method=flickr.favorites.getList&api_key=14c2d7ab479117745022e93c2474fbb9&user_id=192962387%40N04&extras=description%2C+license%2C+date_upload%2C+date_taken%2C+owner_name%2C+icon_server%2C+original_format%2C+last_update%2C+geo%2C+tags%2C+machine_tags%2C+o_dims%2C+views%2C+media%2C+path_alias%2C+url_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_c%2C+url_l%2C+url_o&per_page=100&page=&format=json&nojsoncallback=1
    @GET("services/rest/?method=flickr.favorites.getList&api_key=14c2d7ab479117745022e93c2474fbb9&user_id=192962387%40N04&extras=description%2C+license%2C+date_upload%2C+date_taken%2C+owner_name%2C+icon_server%2C+original_format%2C+last_update%2C+geo%2C+tags%2C+machine_tags%2C+o_dims%2C+views%2C+media%2C+path_alias%2C+url_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_c%2C+url_l%2C+url_o&per_page=100&page=&format=json&nojsoncallback=1")
    Call<PhotoBg> getDataDetai();
//https://canhwallpaper.herokuapp.com/getlist
    //http://jsonviewer.stack.hu/#https://www.flickr.com/services/rest/?method=flickr.favorites.getList&api_key=14c2d7ab479117745022e93c24 n%2C+license%2C+date_upload%2C+date_taken%2C+owner_name%2C+icon_server%2C+original_format%2C+last_update%2C+geo%2C+tags%2C+machine_tags%2C+o_dims%2C+views%2C+media%2C+path_alias%2C+url_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_c%2C+url_l%2C+url_o&per_page=100&page=&format=json&nojsoncallback=1")


    //    @GET("getlist")
//    Call<Wallpaper> getDataWallPaper();
    @GET("getlist")
    Call<List<Wallpaper>> getWallpaper();

}

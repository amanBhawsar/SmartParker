package com.example.smartparker.data.remote;

import androidx.annotation.ContentView;
import androidx.annotation.RequiresApi;

import com.example.smartparker.data.model.GetSlots;
import com.example.smartparker.data.model.Loginn;
import com.example.smartparker.data.model.Post;
import com.example.smartparker.data.model.indislot;
import com.example.smartparker.data.model.PostLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {

    @POST("/register")
    @FormUrlEncoded
    Call<Post> savePost(@Field("username") String username,
                        @Field("password") String password,
                        @Field("name") String name,
                        @Field("mobile") String mobile,
                        @Field("car_no") String car_no);

    @FormUrlEncoded
    @POST("/login")
    Call<PostLogin> loginPost(@Field("username") String username,
                              @Field("password") String password);

    @GET("/slots")
    Call<GetSlots> getSlots();

    @PUT("/slot/{id}")
    Call<indislot> updateslot(@Path("id") int id,@Field("status") int status);
}
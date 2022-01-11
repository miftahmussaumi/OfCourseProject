package com.example.ofcourse.api;

import com.example.ofcourse.Model.ResponseDetailGuru;
import com.example.ofcourse.Model.ResponseGuru;
import com.example.ofcourse.Model.ResponseReview;
import com.example.ofcourse.Model.login.Login;
import com.example.ofcourse.Model.register.Register;
import com.example.ofcourse.Model.ResponseMenu;
import com.example.ofcourse.responsemodelsearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("api/login")
    Call<Login> loginResponse(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("api/register")
    Call<Register> registerResponse(@Field("name") String name, @Field("email") String email, @Field("phone") String phone, @Field("password") String password);

    @GET("api/mapel")
    Call<List<ResponseMenu>>getPost();

    @GET("api/guru")
    Call<List<responsemodelsearch>> getGuru();

    @GET("/api/guru/mapel/{id}")
    Call<List<ResponseGuru>>getDataGuru(@Path("id") int postID);

    @GET("/api/guru/review/{id}")
    Call<List<ResponseReview>>getReview(@Path("id") int reviewID);

    @GET("api/cari/")
    Call<List<responsemodelsearch>> getQuery(
            @Query("s") String s
    );

//    @FormUrlEncoded
//    @POST("api/editprofil")
//    Call<Editresponse> editResponse(
//            @Field("id") String id,
//            @Field("name") String name,
//            @Field("email") String email,
//            @Field("phone") String phone);
}

package com.example.ofcourse.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private static  final String BASE_URL = "https://ofcourse2.herokuapp.com/";
    private  static Retrofit retrofit;
    private static ApiClient clientobject;

    public  static Retrofit getClient(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

//    public static synchronized ApiClient getInstance(){
//        if (clientobject==null)
//            clientobject=new ApiClient();
//
//        return clientobject;
//    }
//
//    public ApiInterface getapi(){
//        return retrofit.create(ApiInterface.class);
//    }

}

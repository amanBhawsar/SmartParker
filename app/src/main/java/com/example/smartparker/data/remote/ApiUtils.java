package com.example.smartparker.data.remote;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://flask-smart-parking.herokuapp.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

//    public static APIServiceLogin getAPIServiceLogin() {
//
//        return RetrofitClient.getClient(BASE_URL).create(APIServiceLogin.class);
//    }
}

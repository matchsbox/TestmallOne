package com.example.match.testmallone.http;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;


/**
 * Created by match on 2018/12/12.
 */

public class OkHttpHelper {

    private Gson gson;
    private Handler handler;
    private static OkHttpClient okHttpClient;

    private OkHttpHelper() {
        okHttpClient=new OkHttpClient();
        okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(10, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);

        gson=new Gson();
        handler=new Handler(Looper.getMainLooper());
    }

    ;

    public static OkHttpHelper getInstance() {


        return null;
    }

    public void get(String url, BaseCallback callback) {

        Request requst = buildRequest(url, null, HttpMethodType.GET);
        doRequset(requst, callback);
    }

    public void post(String url, Map<String, String> params, BaseCallback callback) {

        Request requst = buildRequest(url, params, HttpMethodType.POST);
        doRequset(requst, callback);
    }


    public void doRequset(final Request request, final BaseCallback callback) {

        callback.onRequestbefroe(request);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFailure(request, e);
            }

            @Override
            public void onResponse(Response response) throws IOException {

                if (response.isSuccessful()) {
                    String resultStr = response.body().string();

                    if (callback.mType == StringTokenizer.class) {
                        callback.onSuccess(response, resultStr);

                        callbackSuccess(callback,response,resultStr);
                    } else {
                        try {
                            Object object = gson.fromJson(resultStr, callback.mType);
                            callback.onSuccess(response, object);

                            } catch (JsonParseException e) {
                            callback.onError(response, response.code(), e);

                            callbackError(callback,response, response.code(), e);

                        }

                    }
                } else {
                    callback.onError(response, response.code(), null);
                }
            }
        });


    }

    private Request buildRequest(String url, Map<String, String> params, HttpMethodType methodType) {


        Request.Builder builder = new Request.Builder();
        builder.url(url);

        if (methodType == HttpMethodType.GET) {
            builder.get();
        } else if (methodType == HttpMethodType.POST) {
            RequestBody body = buildFormData(params);
            builder.post(body);
        }
        return builder.build();


    }

    private RequestBody buildFormData(Map<String, String> params) {

        FormEncodingBuilder builder = new FormEncodingBuilder();
        if (params != null) {
            //从params中逐个取出放入Map
            for (Map.Entry<String, String> enty : params.entrySet()) {
                builder.add(enty.getKey(), enty.getValue());
         }
        }
        return builder.build();
    }

    private  void callbackSuccess(final BaseCallback callback, final Response response, final Object object){

        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(response,object);
            }
        });
    }
    private  void callbackError(final BaseCallback callback, final Response response, final Object object,final JsonParseException e){

        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(response, response.code(), e);
            }
        });
    }

    enum HttpMethodType {
        GET,
        POST

    }

}

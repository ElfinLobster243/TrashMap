package com.example.trashmap;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.core.content.FileProvider;

import java.io.File;


public class WebViewClientImpl extends WebViewClient {

    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
//        if(url.contains("http://192.168.2.10:5500/")) return false;
//        File arquivo = new File(url);
//        Uri uri = FileProvider.getUriForFile(activity.getBaseContext(), "com.example.trashmap.GenericFileProvider",arquivo);
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        activity.startActivity(intent);

        Intent intent = new Intent(activity,MainActivity.class).putExtra("url",url);
        activity.startActivity(intent);
        return true;
    }


}
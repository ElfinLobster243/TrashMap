package com.example.trashmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.trashmap.R;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webview);
        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        myWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        myWebView.setWebViewClient(webViewClient);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

    String url;
    if(getIntent().getExtras() != null){
        url = getIntent().getExtras().getString("url");

    }else{
        url = "file:///android_asset/index.html";
    }

        myWebView.loadUrl(url);
//        myWebView.loadUrl("200.131.14.132/home/alunoweb2018/public_html/AF04/marcos_pires/Web2/index.html");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
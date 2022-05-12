package com.aramvirabyan.meditationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PreferencesManager extends AppCompatActivity {

    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_manager);

        context = getApplicationContext();

        WebView webView = findViewById(R.id.preferencesmanager_wv);
        WebSettings webSettings = webView.getSettings();
        webView.setWebChromeClient(new WebChromeClient());
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new PreferencesManagerInterface(this), "PreferencesManager");
        webView.loadUrl(context.getString(R.string.staticRenderer_server) + "/survey/");
    }
}
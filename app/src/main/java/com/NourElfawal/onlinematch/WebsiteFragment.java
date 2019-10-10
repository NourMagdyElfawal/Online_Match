package com.NourElfawal.onlinematch;


import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebsiteFragment extends Fragment {
    private String url;

    public WebsiteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_table, container, false);
        WebView webView = v.findViewById(R.id.webView);

        Bundle bundle = this.getArguments();

        if(bundle != null){
            String value="";
            value=bundle.getString("key");
            if((value!=null)) {
                Log.e("key",value);

                if (value.equalsIgnoreCase("كورة 4 لايف - kooora4live")) {
                    url = "https://www.kooora4live.com";
                    OpenWeb(url, webView);
                } else if (value.equalsIgnoreCase("يلا شووت - Yalla Shoot")) {
                    url = "http://www.yalla-shoot.com/live/index.php";
                    OpenWeb(url, webView);

                } else if (value.equalsIgnoreCase("Table")) {
                    url = "https://www.yallakora.com/match-center";
                    OpenWeb(url, webView);
                }
            }
        }


//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webView.loadUrl("https://www.yallakora.com/match-center");
//        webView.setWebViewClient(new WebViewClient());
        return v;
    }

    private void OpenWeb(String url, WebView webView) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setAllowFileAccess(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT < 18) {
            webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        }
        webSettings.setDatabaseEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());

    }

}

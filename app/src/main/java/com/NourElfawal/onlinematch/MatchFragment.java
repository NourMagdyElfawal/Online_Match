package com.NourElfawal.onlinematch;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {
    WebView tableWebV;


    public MatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match, container, false);
        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.rvMatch);
        ListLinksAdapter listLinksAdapter=new ListLinksAdapter();
        recyclerView.setAdapter(listLinksAdapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;


//        webView = v.findViewById(R.id.webView);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webView.loadUrl("https://www.yallakora.com/match-center");
//        webView.setWebViewClient(new WebViewClient());



    }

}

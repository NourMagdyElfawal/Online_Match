package com.NourElfawal.onlinematch;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{
    ImageView imgMatch, imgTable;
    protected FragmentActivity mActivity;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);



        imgMatch = view.findViewById(R.id.imgMatch);
        imgTable = view.findViewById(R.id.imgTable);

        imgMatch.setOnClickListener(this);
        imgTable.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.imgMatch:
                MatchFragment matchFragment=new MatchFragment();
                if(getActivity()!=null)
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,matchFragment).addToBackStack( "tag" ).commit();
                break;
            case R.id.imgTable:
                WebsiteFragment websiteFragment =new WebsiteFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key","Table");
                websiteFragment.setArguments(bundle);
                // Put anything what you want
                if(getActivity()!=null)
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, websiteFragment).addToBackStack( "tag" ).commit();
                break;

        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        if (context instanceof Activity){
//            mActivity =(Activity) context;
//        }

    }
}



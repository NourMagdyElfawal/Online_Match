package com.NourElfawal.onlinematch;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ListLinksAdapter extends RecyclerView.Adapter {
    String websiteName;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return OurData.title.length;
    }


    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imgItem;
        private TextView txtItem;
        public OurData ourData;



        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem=itemView.findViewById(R.id.imgItem);
            txtItem=itemView.findViewById(R.id.txtItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.e("Tag", String.valueOf(txtItem.getText().toString()));
            if(txtItem.getText().toString().equalsIgnoreCase("كورة 4 لايف - kooora4live")){
                websiteName="كورة 4 لايف - kooora4live";
                OpenWebsite(websiteName,v);
            }
            else if(txtItem.getText().toString().equalsIgnoreCase("يلا شووت - Yalla Shoot")) {
                websiteName="يلا شووت - Yalla Shoot";
                OpenWebsite(websiteName,v);
            }
        }

        private void OpenWebsite(String websiteName, View v) {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Bundle bundle = new Bundle();
            bundle.putString("key",websiteName); // Put anything what you want
            WebsiteFragment websiteFragment =new WebsiteFragment();
            websiteFragment.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, websiteFragment).addToBackStack( "tag" ).commit();


        }

        public void bindView (int position){
            imgItem.setImageResource(OurData.imagePath[position]);
            txtItem.setText(OurData.title[position]);



        }
    }

}

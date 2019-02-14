package com.example.software02.newcryptotracker.Adapters;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.software02.newcryptotracker.Interfaces.ItemClickListener;
import com.example.software02.newcryptotracker.Interfaces.ItemDragListener;
import com.example.software02.newcryptotracker.Model.CryptoNews;
import com.example.software02.newcryptotracker.NewsContentActivity;
import com.example.software02.newcryptotracker.R;
import com.squareup.picasso.Picasso;


public class CryptoRecyclerView extends RecyclerView.Adapter<CryptoViewHolder> {

    private CryptoNews rootObject =null;
    private Context mainActivityContext = null;

    public CryptoRecyclerView(CryptoNews rootObjects, Context mainActivityContext){
        this.rootObject = rootObjects;
        this.mainActivityContext = mainActivityContext;
    }

    @NonNull
    @Override
    public CryptoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        final View itemView = inflater.inflate(R.layout.card_layout,viewGroup,false);
        return  new CryptoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CryptoViewHolder cryptoViewHolder, final int i) {
        cryptoViewHolder.newsTitle.setText(rootObject.getArticals().get(i).getTitle());
        if(rootObject.getArticals().get(i).getUrlToImage() != null){
           Picasso.get().load(rootObject.getArticals().get(i).getUrlToImage()).into(cryptoViewHolder.imageView);
        }

        cryptoViewHolder.setItemClickListener(new ItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view, int position) {
                Bundle newsBundle = new Bundle();
                newsBundle.putString("imageUrl", rootObject.getArticals().get(i).getUrlToImage());
                newsBundle.putString("titleText", rootObject.getArticals().get(i).getTitle());
                newsBundle.putString("contentText", rootObject.getArticals().get(i).getContent());

                Intent intent = new Intent(mainActivityContext, NewsContentActivity.class);
                intent.putExtras(newsBundle);
                ActivityOptions activityStartOptions = ActivityOptions.
                        makeSceneTransitionAnimation((Activity) cryptoViewHolder.imageView.getContext(),
                                cryptoViewHolder.imageView,"robot");
                mainActivityContext.startActivity(intent,activityStartOptions.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return rootObject.getArticals().size();
    }
}

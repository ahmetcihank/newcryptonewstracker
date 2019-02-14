package com.example.software02.newcryptotracker.Adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.software02.newcryptotracker.Interfaces.ItemClickListener;
import com.example.software02.newcryptotracker.Interfaces.ItemDragListener;
import com.example.software02.newcryptotracker.Interfaces.MyTouchListener;
import com.example.software02.newcryptotracker.R;

public class CryptoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title;
    TextView newsTitle;
    ImageView imageView;
    ItemClickListener itemClickListener;
    ItemDragListener itemDragListener;
    CardView cardView;

    public CryptoViewHolder(@NonNull View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.btTitle);
        newsTitle =(TextView) itemView.findViewById(R.id.newsTitle);
        imageView = (ImageView) itemView.findViewById(R.id.btImage);
        cardView = (CardView) itemView.findViewById(R.id.itemCardView);
        itemView.setOnClickListener(this);

        /*For Ghost Screen Effect in Card View(Dissmissed For Now)*/
       /* itemView.setOnTouchListener(new MyTouchListener()); */
    }

    @Override
    public void onClick(View view) {
       itemClickListener.onClick(view, getAdapterPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

}

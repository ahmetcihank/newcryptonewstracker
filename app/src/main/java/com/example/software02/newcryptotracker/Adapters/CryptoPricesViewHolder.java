package com.example.software02.newcryptotracker.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.software02.newcryptotracker.Interfaces.ItemClickListener;
import com.example.software02.newcryptotracker.R;

public class CryptoPricesViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

    TextView cryptoCurrencyName = null;
    ItemClickListener itemClickListener;
    LinearLayout expandableView = null;
    RelativeLayout foreGround = null;

    public CryptoPricesViewHolder(@NonNull View itemView) {
        super(itemView);
        cryptoCurrencyName = (TextView) itemView.findViewById(R.id.crypto_currency_name);
       // expandableView = (LinearLayout) itemView.findViewById(R.id.expandable_layout);
        foreGround = (RelativeLayout) itemView.findViewById(R.id.foreground);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public RelativeLayout getForeGround(){
        return  this.foreGround;
    }
}

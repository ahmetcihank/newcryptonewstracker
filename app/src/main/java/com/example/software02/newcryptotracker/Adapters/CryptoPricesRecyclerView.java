package com.example.software02.newcryptotracker.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.software02.newcryptotracker.Interfaces.ItemClickListener;
import com.example.software02.newcryptotracker.Model.Data;
import com.example.software02.newcryptotracker.Model.RootPrices;
import com.example.software02.newcryptotracker.R;

public class CryptoPricesRecyclerView extends RecyclerView.Adapter<CryptoPricesViewHolder>{

    RootPrices rootPrices = null;
    Context mainActivityContext = null;
    private SparseBooleanArray expandState = new SparseBooleanArray();

    public  CryptoPricesRecyclerView(RootPrices rootPrices, Context mainActivityContext){
        this.rootPrices = rootPrices;
        this.mainActivityContext = mainActivityContext;
        for (int i = 0; i <rootPrices.getData().size(); i++) {
            expandState.append(i, false);
        }
    }

    @NonNull
    @Override
    public CryptoPricesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.cryptoprices_card_layout, viewGroup, false);
        return  new CryptoPricesViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final CryptoPricesViewHolder cryptoPricesViewHolder, int i) {
        cryptoPricesViewHolder.cryptoCurrencyName.setText(rootPrices.getData().get(i).getName());
        final boolean isExpanded = expandState.get(i);
        cryptoPricesViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(mainActivityContext,"Test", Toast.LENGTH_SHORT).show();
            }
        });
         /*  cryptoPricesViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
             final boolean isExpanded = expandState.get(position);
                cryptoPricesViewHolder.expandableView.setVisibility(isExpanded?View.VISIBLE:View.GONE);

                if (cryptoPricesViewHolder.expandableView.getVisibility() == View.VISIBLE){
                    cryptoPricesViewHolder.expandableView.animate().
                            translationY(0).setDuration(1000);
                    //cryptoPricesViewHolder.expandableView.setVisibility(View.GONE);
                    expandState.put(position, false);
                }
                else{
                    Animation slideUp = AnimationUtils.loadAnimation(mainActivityContext, R.anim.visibility);
                    cryptoPricesViewHolder.expandableView.animate().
                            translationY(cryptoPricesViewHolder.expandableView.getHeight()).setDuration(1000);
                    //cryptoPricesViewHolder.expandableView.setVisibility(View.VISIBLE);
                   // cryptoPricesViewHolder.expandableView.startAnimation(slideUp);
                    expandState.put(position, true);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return rootPrices.getData().size();
    }

    public void removeItem(int position){
        rootPrices.getData().remove(position);
        notifyItemRemoved(position);
    }

    public  void restoreItem(Data data,int position){
        rootPrices.getData().add(position, data);
        notifyItemInserted(position);
    }
}

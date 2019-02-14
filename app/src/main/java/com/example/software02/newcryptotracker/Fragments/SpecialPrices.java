package com.example.software02.newcryptotracker.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.software02.newcryptotracker.Adapters.CryptoPricesRecyclerView;
import com.example.software02.newcryptotracker.Adapters.CryptoPricesViewHolder;
import com.example.software02.newcryptotracker.Interfaces.ItemClickListener;
import com.example.software02.newcryptotracker.Interfaces.ItemTouchHelperListener;
import com.example.software02.newcryptotracker.Model.Data;
import com.example.software02.newcryptotracker.Model.RootPrices;
import com.example.software02.newcryptotracker.R;
import com.example.software02.newcryptotracker.Utility.RecyclerViewTouchHelper;
import com.example.software02.newcryptotracker.Utility.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecialPrices  extends Fragment implements ItemClickListener, ItemTouchHelperListener{

    private RootPrices cryptoData = null;
    CryptoPricesRecyclerView adapter = null;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView cryptoPricesList = (RecyclerView) view.findViewById(R.id.cryptoPricesList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        cryptoPricesList.setLayoutManager(linearLayoutManager);
        cryptoPricesList.setItemAnimator(new DefaultItemAnimator());
        cryptoPricesList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        final ItemTouchHelper.SimpleCallback itemTouchHelper = new RecyclerViewTouchHelper(0, ItemTouchHelper.LEFT,
                this, cryptoData, adapter);


        Utility.cryptoPricesService cryptoPricesService = Utility.getRetrofitForCurrency("https://pro-api.coinmarketcap.com");
        cryptoPricesService.listCryptoPrices().enqueue(new Callback<RootPrices>() {
            @Override
            public void onResponse(Call<RootPrices> call, Response<RootPrices> response) {
                cryptoData = response.body();
                adapter = new CryptoPricesRecyclerView(cryptoData, getContext());
                cryptoPricesList.setAdapter(adapter);
                new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(cryptoPricesList);
            }

            @Override
            public void onFailure(Call<RootPrices> call, Throwable t) {
                Toast.makeText(getContext(), "Op Failed My Friend", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_prices_layout, container, false);
        return view;
    }

    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public void onSwipe(RecyclerView.ViewHolder viewHolder, int direction, int position) {
      if(viewHolder instanceof CryptoPricesViewHolder){
          String name = cryptoData.getData().get(position).getName();
          Data deletedItem = cryptoData.getData().get(viewHolder.getAdapterPosition());
          int deletedIndex = viewHolder.getAdapterPosition();
          adapter.removeItem(deletedIndex);
          adapter.notifyItemRemoved(deletedIndex);
      }
    }
}

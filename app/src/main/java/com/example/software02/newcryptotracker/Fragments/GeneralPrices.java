package com.example.software02.newcryptotracker.Fragments;

import android.content.ClipData;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.software02.newcryptotracker.Adapters.CryptoRecyclerView;
import com.example.software02.newcryptotracker.Interfaces.ItemClickListener;
import com.example.software02.newcryptotracker.Interfaces.ItemDragListener;
import com.example.software02.newcryptotracker.Interfaces.MyTouchListener;
import com.example.software02.newcryptotracker.Model.CryptoNews;
import com.example.software02.newcryptotracker.R;
import com.example.software02.newcryptotracker.Utility.Utility;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneralPrices extends Fragment implements ItemClickListener, ItemDragListener{

    private RecyclerView cryptoList = null;
    private CryptoNews cryptoData = null;
    private ItemTouchHelper mItemTouchHelper;
    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        cryptoList = (RecyclerView) view.findViewById(R.id.general_price_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        cryptoList.setLayoutManager(linearLayoutManager);
        Utility.cryptoService mService =Utility.getRetrofit("https://newsapi.org");
        mService.listCryptos().enqueue(new Callback<CryptoNews>() {
            @Override
            public void onResponse(Call<CryptoNews> call, Response<CryptoNews> response) {
                cryptoData = response.body();
                final CryptoRecyclerView adapter = new CryptoRecyclerView(cryptoData, getContext());
                cryptoList.setAdapter(adapter);
                /*
                ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                        new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
                            @Override
                            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder dragged,
                                                  @NonNull RecyclerView.ViewHolder target) {
                                int position_dragged = dragged.getAdapterPosition();
                                int position_target = target.getAdapterPosition();
                                //cryptoList.getChildAt(position_dragged).setElevation(20);

                                Collections.swap(cryptoData.getArticals(),position_dragged, position_target);
                                adapter.notifyItemMoved(position_dragged, position_target);
                                return false;
                            }
                            @Override
                            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                            }
                        });
                itemTouchHelper.attachToRecyclerView(cryptoList);*/

                ItemTouchHelper.Callback itemTouchCallback = new ItemTouchHelper.Callback() {
                    @Override
                    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                        return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,
                                ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
                    }

                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder dragged, @NonNull RecyclerView.ViewHolder target) {
                        int position_dragged = dragged.getAdapterPosition();
                        int position_target = target.getAdapterPosition();
                        Collections.swap(cryptoData.getArticals(), dragged.getAdapterPosition(), target.getAdapterPosition());
                        // and notify the adapter that its dataset has changed
                        adapter.notifyItemMoved(dragged.getAdapterPosition(), target.getAdapterPosition());
                        return true;
                    }
                    @Override
                    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                        super.onSelectedChanged(viewHolder, actionState);
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                    }
                };
                ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
                itemTouchHelper.attachToRecyclerView(cryptoList);
            }

            @Override
            public void onFailure(Call<CryptoNews> call, Throwable t) {
                Toast.makeText(getContext(), "Operation Failed Mate",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_prices_layout, container, false);
        return view;
    }

    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public void Drag(View view, DragEvent dragEvent) {

    }
}

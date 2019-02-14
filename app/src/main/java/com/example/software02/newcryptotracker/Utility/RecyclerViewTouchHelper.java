package com.example.software02.newcryptotracker.Utility;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.software02.newcryptotracker.Adapters.CryptoPricesRecyclerView;
import com.example.software02.newcryptotracker.Adapters.CryptoPricesViewHolder;
import com.example.software02.newcryptotracker.Interfaces.ItemTouchHelperListener;
import com.example.software02.newcryptotracker.Model.RootPrices;

import java.util.Collections;

public class RecyclerViewTouchHelper extends ItemTouchHelper.SimpleCallback {
    private ItemTouchHelperListener itemTouchHelperListener = null;
    private RootPrices rootPrices;
    private  CryptoPricesRecyclerView adapter;

    public RecyclerViewTouchHelper(int dragDirs, int swipeDirs, ItemTouchHelperListener itemTouchHelperListener,
                                   RootPrices rootPrices, CryptoPricesRecyclerView adapter) {
        super(dragDirs, swipeDirs);
        this.itemTouchHelperListener = itemTouchHelperListener;
        this.rootPrices = rootPrices;
        this.adapter = adapter;
    }

     /*  @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
     return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,ItemTouchHelper.DOWN |
                ItemTouchHelper.UP| ItemTouchHelper.START | ItemTouchHelper.END);
    }*/

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder dragged, @NonNull RecyclerView.ViewHolder target) {
      /*  int position_dragged = dragged.getAdapterPosition();
        int position_target = target.getAdapterPosition();
        Collections.swap(rootPrices.getData(),dragged.getAdapterPosition(), target.getAdapterPosition());
        adapter.notifyItemMoved(position_dragged,position_target);*/
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
       if(itemTouchHelperListener != null){
           itemTouchHelperListener.onSwipe(viewHolder,i, viewHolder.getAdapterPosition());
       }
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView,
                          @NonNull RecyclerView.ViewHolder viewHolder) {
       View forGroundView =((CryptoPricesViewHolder)viewHolder).getForeGround();
       getDefaultUIUtil().clearView(forGroundView);
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
         View foreGroundView = ((CryptoPricesViewHolder)viewHolder).getForeGround();
         getDefaultUIUtil().onDraw(c, recyclerView,foreGroundView, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                                RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View foreGroundView =((CryptoPricesViewHolder)viewHolder).getForeGround();
        getDefaultUIUtil().onDrawOver(c, recyclerView, foreGroundView, dX, dY, actionState, isCurrentlyActive);

    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
       if(itemTouchHelperListener != null){

       }
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }


}

package com.example.software02.newcryptotracker.Interfaces;

import android.support.v7.widget.RecyclerView;

public interface ItemTouchHelperListener {
    public void onSwipe(RecyclerView.ViewHolder viewHolder, int direction, int position);
}

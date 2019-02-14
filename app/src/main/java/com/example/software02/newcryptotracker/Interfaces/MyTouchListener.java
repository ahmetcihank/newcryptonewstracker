package com.example.software02.newcryptotracker.Interfaces;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;

public class MyTouchListener  implements View.OnLongClickListener{

    @Override
    public boolean onLongClick(View view) {

            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.VISIBLE);
            return true;
    }
}

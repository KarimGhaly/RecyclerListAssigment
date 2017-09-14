package com.example.admin.recyclerlistassigment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Admin on 9/13/2017.
 */

public class Swiper extends ItemTouchHelper.SimpleCallback{
    RVAdapter rvAdapter;

    public Swiper(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public Swiper(RVAdapter rvAdapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN,ItemTouchHelper.LEFT);
        this.rvAdapter = rvAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        rvAdapter.Dismissitem(viewHolder.getAdapterPosition());
    }
}

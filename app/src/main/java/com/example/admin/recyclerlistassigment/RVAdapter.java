package com.example.admin.recyclerlistassigment;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 9/13/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    Context context;
    List<Animals> animalsList = new ArrayList<>();

    public RVAdapter(List<Animals> animalsList) {
        this.animalsList = animalsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_layout, parent, false);
        return new ViewHolder(view);
    }
    public void Dismissitem(int postition)
    {
        Animals a = animalsList.get(postition);

        Database db = new Database(context);
        db.DeleteItem(a.getName());
        animalsList.remove(postition);
        this.notifyItemRemoved(postition);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Animals animal = animalsList.get(position);
        holder.txtName.setText(animal.getName());
        holder.txtAge.setText(String.valueOf(animal.getAge()));
        holder.txtCategory.setText(animal.getCategory());
        holder.txtWeight.setText(String.valueOf(animal.getWeight()));
        holder.imgView.setImageResource(animal.getImageID());
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
    }


    @Override
    public int getItemCount() {
        return animalsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtAge;
        TextView txtWeight;
        TextView txtCategory;
        ImageView imgView;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtAge = (TextView) itemView.findViewById(R.id.txtAge);
            txtCategory = (TextView) itemView.findViewById(R.id.txtCategory);
            txtWeight = (TextView) itemView.findViewById(R.id.txtWeight);
            imgView = (ImageView) itemView.findViewById(R.id.IMGView);
        }
    }
}

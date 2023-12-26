package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<Category> categories;

    public CategoryAdapter(Context context,ArrayList<Category> category){
        categories=category;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivCategory;
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCategory=itemView.findViewById(R.id.ivPic);
            tvName=itemView.findViewById(R.id.Name);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory_design,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.ivCategory.setImageResource(category.getImageID());
        holder.tvName.setText(category.getName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}

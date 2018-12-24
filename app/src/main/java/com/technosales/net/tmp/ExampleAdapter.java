package com.technosales.net.tmp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private Context context;
    private ArrayList<ExampleItem> exampleItemArrayList;

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleItems){
        this.context = context;
        exampleItemArrayList = exampleItems;
    }

    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false);

        return new ExampleViewHolder(view);
    }

    public void onBindViewHolder(ExampleViewHolder holder, int position){

        ExampleItem currentItem = exampleItemArrayList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikeCount();

        holder.textView_creator.setText("Creator Name: " + creatorName);
        holder.textView_likes.setText("Likes: " + likeCount);
//        Picasso.get(context).load(imageUrl).fit().centerInside().into(holder.imageView);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.imageView);
    }

    public int getItemCount(){
        return exampleItemArrayList.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView_creator;
        public TextView textView_likes;

        public ExampleViewHolder(View intemView){
            super(intemView);
            imageView = itemView.findViewById(R.id.iv);
            textView_creator = intemView.findViewById(R.id.tv);
            textView_likes = intemView.findViewById(R.id.tv1);

        }

    }


}

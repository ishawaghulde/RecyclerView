package com.example.recyclerview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private Context mCtx;
    private Typeface myFont;

    //we are storing all the products in a list
    private List<Card> cardList;

    public RecyclerViewAdapter(Context mCtx, List<Card> cardList, Typeface myFont) {
        this.mCtx = mCtx;
        this.cardList = cardList;
        this.myFont = myFont;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_cards, null);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        //getting the product of the specified position
        Card card = cardList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(card.getTitle());
        holder.textViewTitle.setTypeface(myFont);

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(card.getImage()));
        holder.cardView.setAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.fade_transition));

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView imageView;
        CardView cardView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
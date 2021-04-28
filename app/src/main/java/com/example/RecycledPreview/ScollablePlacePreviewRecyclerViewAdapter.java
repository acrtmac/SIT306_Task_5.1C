package com.example.RecycledPreview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScollablePlacePreviewRecyclerViewAdapter extends RecyclerView.Adapter<ScollablePlacePreviewRecyclerViewAdapter.PlacesPreviewViewHolder> {

    private List<PlacesPreview> PlacesPreviewList;
    private Context PlacesPreviewContext;
    private OnRowClickListener listener;

    public ScollablePlacePreviewRecyclerViewAdapter(List<PlacesPreview> placesPreviewList, Context PlacesPreviewContext, OnRowClickListener clickListener) {
        this.PlacesPreviewList = placesPreviewList;
        this.PlacesPreviewContext = PlacesPreviewContext;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public PlacesPreviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View PlacesView = LayoutInflater.from(PlacesPreviewContext).inflate(R.layout.description, parent, false);
        return new PlacesPreviewViewHolder(PlacesView, listener);
    }

    public void onBindViewHolder(@NonNull PlacesPreviewViewHolder holder, int position) {
        holder.placeImageView.setImageResource(PlacesPreviewList.get(position).getImage());
        holder.nameTextView.setText(PlacesPreviewList.get(position).getName());
        holder.descriptionTextView.setText(PlacesPreviewList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return PlacesPreviewList.size();
    }

    public class PlacesPreviewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView placeImageView;
        private TextView nameTextView, descriptionTextView;
        public OnRowClickListener onRowClickListener;

        public PlacesPreviewViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            placeImageView = itemView.findViewById(R.id.verticalImageView);
            nameTextView = itemView.findViewById(R.id.placeToGoNametextView);
            descriptionTextView = itemView.findViewById(R.id.placeToGoDescriptiontextView);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnRowClickListener {
        void onItemClick(int position);
    }
}

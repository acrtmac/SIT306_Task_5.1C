package com.example.RecycledPreview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScollablePicturePreviewRecyclerViewAdapter extends RecyclerView.Adapter<ScollablePicturePreviewRecyclerViewAdapter.DestinationViewHolder> {

    private List<PicturePreview> PitcurePreviewList;
    private Context PicturePreviewcontext;

    public ScollablePicturePreviewRecyclerViewAdapter(List<PicturePreview> topDestinationsList, Context PicturePreviewcontext) {
        this.PitcurePreviewList = topDestinationsList;
        this.PicturePreviewcontext = PicturePreviewcontext;
    }

    @NonNull
    @Override
    public DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(PicturePreviewcontext).inflate(R.layout.placespreview_verti, parent, false);
        return new DestinationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationViewHolder holder, int position) {
        holder.ImageviewforPicturePreview.setImageResource(PitcurePreviewList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return PitcurePreviewList.size();
    }

    public class DestinationViewHolder extends RecyclerView.ViewHolder {
        private ImageView ImageviewforPicturePreview;

        public DestinationViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageviewforPicturePreview = itemView.findViewById(R.id.PicturePreview_);
        }
    }
}

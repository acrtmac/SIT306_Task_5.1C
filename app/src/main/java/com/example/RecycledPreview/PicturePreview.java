package com.example.RecycledPreview;

public class PicturePreview {
    private int id, image;

    public PicturePreview(int id, int image){
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

}


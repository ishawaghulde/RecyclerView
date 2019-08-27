package com.example.recyclerview;

public class Card {
    private String title;
    private int image;

    public Card(String title, int image){
        this.title = title;
        this.image = image;
    }

    public String getTitle(){
        return title;
    }

    public int getImage() {
        return image;
    }
}

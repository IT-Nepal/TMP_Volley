package com.technosales.net.tmp;

public class ExampleItem {
    private String imageUrl;
    private String creator;
    private int likes;

    public ExampleItem(String imageUrl, String creator, int likes){
        this.imageUrl = imageUrl;
        this.creator = creator;
        this.likes = likes;
    }

    public String getImageUrl(){
        return imageUrl;
    }
    public String getCreator(){
        return creator;
    }
    public int getLikeCount(){
        return likes;
    }
}

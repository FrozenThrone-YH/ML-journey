package com.example.mynaveractivity;

public class BookModel {

    private String b_title,b_author,b_price,b_img;

    public BookModel(){
        //default
    }
    public BookModel(String b_title,String b_author,String b_price,String b_img){
        this.b_title = b_title;
        this.b_author = b_author;
        this.b_price = b_price;
        this.b_img = b_img;
    }

    //setter / getter
    public String getB_title() {
        return b_title;
    }
    public void setB_title(String b_title) {
        this.b_title = b_title;
    }
    public String getB_author() {
        return b_author;
    }
    public void setB_author(String b_author) {
        this.b_author = b_author;
    }
    public String getB_price() {
        return b_price;
    }
    public void setB_price(String b_price) {
        this.b_price = b_price;
    }
    public String getB_img() {
        return b_img;
    }
    public void setB_img(String b_img) {
        this.b_img = b_img;
    }
}

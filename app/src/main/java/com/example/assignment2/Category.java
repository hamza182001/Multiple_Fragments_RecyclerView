package com.example.assignment2;

public class Category {
    String name;
    int imageID;

    public Category() {
    }

    public Category(String name,int imageID) {
        this.imageID = imageID;
        this.name=name;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;

    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", imageID=" + imageID +
                '}';
    }
}

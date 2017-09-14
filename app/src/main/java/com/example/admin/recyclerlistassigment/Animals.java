package com.example.admin.recyclerlistassigment;

/**
 * Created by Admin on 9/13/2017.
 */

public class Animals {
    String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    String Category;
    int Age;
    int Weight;
    int ImageID;

    public Animals(String name, String category, int age, int weight, int imageID) {
        Name = name;
        Category = category;
        Age = age;
        Weight = weight;
        ImageID = imageID;
    }


}

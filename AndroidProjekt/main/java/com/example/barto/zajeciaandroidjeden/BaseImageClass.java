package com.example.barto.zajeciaandroidjeden;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

public class BaseImageClass {



    @SerializedName("name")
    public  String imageName;
    @SerializedName("description")
    public String imageDescription;
    @SerializedName("date")
    public String expirationDate;
    @SerializedName("uri")
    public Uri imageUri;

    public BaseImageClass(String imageName, String imageDescription, String expirationDate, Uri imageUri) {
        this.imageName = imageName;
        this.imageDescription = imageDescription;
        this.expirationDate = expirationDate;
        this.imageUri=imageUri;
    }


    public BaseImageClass() {
    }


    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}

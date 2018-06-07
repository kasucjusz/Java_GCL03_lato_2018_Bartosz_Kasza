package com.example.barto.zajeciaandroidjeden;

import com.google.gson.annotations.SerializedName;

public class Tasks {



    @SerializedName("name")
    public  String taskName;
    @SerializedName("description")
    public String taskDescription;
    @SerializedName("date")
    public String expirationDate;

    public Tasks(String taskName, String taskDescription, String expirationDate) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.expirationDate = expirationDate;
    }


    public Tasks() {
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}

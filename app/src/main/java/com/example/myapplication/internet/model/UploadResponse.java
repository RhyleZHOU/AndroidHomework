package com.example.myapplication.internet.model;

import com.google.gson.annotations.SerializedName;

public class UploadResponse {
    @SerializedName("result")
    public Message message;
    @SerializedName("success")
    public boolean success;
}

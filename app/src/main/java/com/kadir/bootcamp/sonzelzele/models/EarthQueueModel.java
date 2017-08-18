package com.kadir.bootcamp.sonzelzele.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by KadirDogan on 8/17/2017.
 */

public class EarthQueueModel {
    @SerializedName("data")
    public ArrayList<EarthQueueItems> data;
}

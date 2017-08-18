package com.kadir.bootcamp.sonzelzele.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by KadirDogan on 8/17/2017.
 */

public class EarthQueueItems {
    @SerializedName("id")
    public String id;

    @SerializedName("tarih2")
    public String tarih2;

    @SerializedName("lokasyon")
    public String lokasyon;

    @SerializedName("lat")
    public String lat;

    @SerializedName("lng")
    public String lng;

    @SerializedName("siddeti")
    public String siddeti;

    @SerializedName("derinlik")
    public String derinlik;
}

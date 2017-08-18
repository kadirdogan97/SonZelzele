package com.kadir.bootcamp.sonzelzele.network;

import com.kadir.bootcamp.sonzelzele.models.EarthQueueModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by KadirDogan on 8/17/2017.
 */

public interface ServiceGenerator {
    @GET("/depremler")
    Call<EarthQueueModel> getEarthQueue();
}

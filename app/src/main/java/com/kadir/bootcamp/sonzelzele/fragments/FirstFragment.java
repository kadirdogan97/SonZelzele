package com.kadir.bootcamp.sonzelzele.fragments;

import android.graphics.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kadir.bootcamp.sonzelzele.R;
import com.kadir.bootcamp.sonzelzele.models.EarthQueueModel;
import com.kadir.bootcamp.sonzelzele.network.Factory;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KadirDogan on 8/11/2017.
 */

public class FirstFragment extends Fragment implements OnMapReadyCallback{
    GoogleMap googleMap;
    MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) view.findViewById(R.id.mapView);
        if(mapView != null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }


    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        this.googleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraPosition Turkey = CameraPosition.builder().target(new LatLng(40,35)).zoom(4).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Turkey));
        Factory.getInstance().getEarthQueue().enqueue(new Callback<EarthQueueModel>() {
            @Override
            public void onResponse(Call<EarthQueueModel> call, Response<EarthQueueModel> response) {
                for(int i = 0; i<10; i++){
                    double lat = Double.parseDouble(response.body().data.get(i).lat);
                    double lng = Double.parseDouble(response.body().data.get(i).lng);
                    String status = response.body().data.get(i).lokasyon;
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title(status));
                }
            }

            @Override
            public void onFailure(Call<EarthQueueModel> call, Throwable t) {

            }
        });
    }
}

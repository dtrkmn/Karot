package com.example.casper.karot_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends FragmentActivity implements GoogleMap.OnMarkerClickListener {

//39.934184, 32.835164
   AutoCompleteTextView auto;
    Button btn;
    Intent map;

    private GoogleMap mMap;
    static final LatLng salda_lake = new LatLng(37.554409, 29.673518);
    static final LatLng van_lake = new LatLng(38.641, 38.641);
    private Marker salda;
    private Marker van;
    Intent home;
    Intent ben;
    String manager;

    //private LatLngBounds center = new LatLngBounds(39.934184,32.835164);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setUpMapIfNeeded();
        home=new Intent(Map.this,HomePage.class);

        auto=(AutoCompleteTextView)findViewById(R.id.text);
        map=new Intent(Map.this,HomePage.class);
        ben=getIntent();
        manager=ben.getStringExtra("send");

        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Universities);
        auto.setAdapter(adaptor);

        van = mMap.addMarker(new MarkerOptions()
                .position(van_lake)
                .draggable(true));

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center.getCenter(), 10));
        CameraUpdate center=
                CameraUpdateFactory.newLatLng(new LatLng(39.527489, 36.142455));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(6);

        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = auto.getText().toString();
                if(name.equals("Muğla Sıtkı Koçman Üniversitesi")){
                    salda.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                }
            }
        });



    }

    private static final String[] Universities = new String[] {
            "Muğla Sıtkı Koçman Üniversitesi","İstanbul Teknik Üniversitesi", "Dokuz Eylül Üniversitesi"


    };

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.setOnMarkerClickListener(this);
        salda = mMap.addMarker(new MarkerOptions()
                .position(salda_lake)
                .draggable(true));

    }

    public boolean onMarkerClick(final Marker marker) {

        if (marker.equals(salda))
        {

            home.putExtra("send",manager);
            Map.this.startActivity(home);
        }
        return true;
    }
}

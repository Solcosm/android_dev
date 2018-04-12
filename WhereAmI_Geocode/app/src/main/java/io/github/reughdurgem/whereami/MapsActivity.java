package io.github.reughdurgem.whereami;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static android.media.CamcorderProfile.get;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    // Define Variables to IDs
    Button zoom, zoom2, terrainChangerSatellite, terrainChangerNormal;
    EditText input;

    // Call APIs
    private GoogleMap mMap;
    private Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Set Title
        setTitle("Google Maps Location Editor");

        // Assign variables to IDs
        zoom = (Button) findViewById(R.id.button);
        zoom2 = (Button) findViewById(R.id.button2);
        terrainChangerSatellite = (Button) findViewById(R.id.button3);
        terrainChangerNormal = (Button) findViewById(R.id.button4);
        input = (EditText) findViewById(R.id.editText);

        // Geocoder Function Setup
        geocoder = new Geocoder(MapsActivity.this);
        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String locationName = v.getText().toString();
                // Geocoder Function
                if (Geocoder.isPresent()) {
                    try {
                        List<Address> addresses = geocoder.getFromLocationName(locationName, 1);
                        if (addresses.size() == 0) {
                            Toast.makeText(MapsActivity.this, "Place not found.", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                        Address address = addresses.get(0);
                        final LatLng location = new LatLng(address.getLatitude(), address.getLongitude());
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, .01f));
                    } catch (IOException e) {
                        Toast.makeText(MapsActivity.this, "Network connection to geocoder service unavailable.", Toast.LENGTH_SHORT).show();
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(MapsActivity.this, "No place entered.", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });

        // Zoom Functionality (x25)
        zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.moveCamera(CameraUpdateFactory.zoomTo(10.0f));
            }
        });

        // Zoom Functionality (x10)
        zoom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.moveCamera(CameraUpdateFactory.zoomTo(1.0f));
            }
        });

        // Terrain View Functionality (Satellite)
        terrainChangerSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        // Terrain View Functionality (Normal)
        terrainChangerNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // MAP TYPE
        mMap.setTrafficEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Ask for user location through permissions
        int GET_MY_PERMS = 1;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Please enable location permissions!", Toast.LENGTH_SHORT).show();
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                /*DO_NOTHING*/
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, GET_MY_PERMS);
            }
        }

        // Allow user to pinpoint location
        mMap.setMyLocationEnabled(true);

        // MAP_MARKERS
        LatLng Florida = new LatLng(26, -81);
        mMap.addMarker(new MarkerOptions().position(Florida).title("Florida"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Florida));

        LatLng NewYork = new LatLng(40, -74);
        mMap.addMarker(new MarkerOptions().position(NewYork).title("New York"));

        LatLng GooglePlex = new LatLng(37, -122);
        mMap.addMarker(new MarkerOptions().position(GooglePlex).title("Googleplex"));
    }
}
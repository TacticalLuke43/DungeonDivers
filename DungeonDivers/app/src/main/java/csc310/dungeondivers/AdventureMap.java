package csc310.dungeondivers;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class AdventureMap extends Fragment implements OnMapReadyCallback {
    GoogleMap mGoogleMap;
    MapView mapView;
    View mView;
    private LocationManager locationManager;
    private LocationListener locationListener;
    Location location;
    double currentLatitude;
    double currentLongitude;
    Drawable charIcon;
    Bitmap bitmap;
    int imageRes;
    ImageView charOnMap;
    int zoomLevel = 16;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.adventure_map, container, false);
        charOnMap = (ImageView) mView.findViewById(R.id.charOnMap);
        //mView.getUiSettings().setScrollGesturesEnabled(false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




        //imageRes = activity2.getCharIcon();
        //int id = getResources().getIdentifier(img, "drawable", getPackageName());
        //bitmap = BitmapFactory.decodeResource(getResources(), imageRes);
        // Marker marker = m.addMarker(new MarkerOptions()
       //         .position(new LatLng(s.lat, s.lon))
       //         .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
       //         .anchor(0.5f, 1f));

       // charIcon = getResources().getDrawable(R.id.img);

        // charIcon = getResources().getIdentifier(img, "drawable", getPackageName());



        mapView = (MapView) mView.findViewById(R.id.adventureMap);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
            /*mapView.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_MOVE) {
                        return true;
                    }
                    return false;
                }
            });
*/
            //mapView.setClickable(false);
           // mapView.getUiSettings().setScrollGesturesEnabled(false);
        }
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        currentLatitude = location.getLatitude();
        currentLongitude = location.getLongitude();
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if(location != null)
                {
                   // Log.e("lat :" , "" + location.getLatitude());
                   // Log.e("Lng :", "" + location.getLongitude());
                }
                currentLatitude = location.getLatitude();
                currentLongitude = location.getLongitude();



                CameraPosition playerLocation = CameraPosition.builder().target(new LatLng(currentLatitude,currentLongitude)).zoom(zoomLevel).bearing(0).build();
                mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(playerLocation));

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        locationManager.requestLocationUpdates("gps", 1000, 1, locationListener);


        adventureActivity2  activity2 = (adventureActivity2) getActivity();
        String playerIcon = activity2.getCharIcon();
        int imageRes = activity2.getIconId();


       // charOnMap.setBackgroundResource(imageRes);
       // AnimationDrawable frameAnimation = (AnimationDrawable) charOnMap.getBackground();
       // frameAnimation.start();
       // charOnMap.setImageResource(R.drawable.w_h_m);

         //charOnMap.setBackgroundResource(R.drawable.whm);
         //AnimationDrawable frameAnimation = (AnimationDrawable) charOnMap.getBackground();
         //frameAnimation.start();
        charOnMap.setBackgroundResource(getResources().getIdentifier(playerIcon, "drawable", getContext().getPackageName()));
        AnimationDrawable frameAnimation = (AnimationDrawable) charOnMap.getBackground();
        frameAnimation.start();
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng currentLocation = new LatLng(currentLatitude, currentLongitude);

     //   Marker marker = googleMap.addMarker(new MarkerOptions()
     //           .position(currentLocation)
     //           .icon(BitmapDescriptorFactory.fromResource(imageRes))
     //           .anchor(0.5f, 1f));

        Marker marker= mGoogleMap.addMarker(new MarkerOptions()
                .position(new LatLng(43.018837, -83.687402))
                .title("Dungeon")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cave)));


       // googleMap.addMarker(new MarkerOptions().position(currentLocation).title("You").snippet("snippet"));
       // CameraPosition playerLocation = CameraPosition.builder().target(currentLocation).zoom(16).bearing(0).tilt(45).build();
        CameraPosition playerLocation = CameraPosition.builder().target(currentLocation).zoom(zoomLevel).bearing(0).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(playerLocation));

//***************************************************************************************************




    }


}

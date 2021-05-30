package com.example.instatram

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        checkPermission()
    }


    var accessLocation = 123 ; // valeur aléatoire
     fun checkPermission(){
         if(Build.VERSION.SDK_INT>=23){
    if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
        requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), accessLocation)
        return}}
         getUserLocation()}

    fun getUserLocation(){
        Toast.makeText(this, "User location access on", Toast.LENGTH_LONG).show()

        var location = MyLocationListener()
        var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 3f, location)

        var myThread = MyThread()
        myThread.start()
    }// implementation à ajouter ultérieurement}


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){accessLocation->{
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                getUserLocation()
            }
            else{Toast.makeText(this,"We cannot access to your location",Toast.LENGTH_LONG).show()}
        }}
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


    }
    lateinit var  myLocation:Location
    inner class MyLocationListener: LocationListener {
        constructor() {
            myLocation = Location("Me")
            myLocation.longitude = 0.0
            myLocation.latitude = 0.0
        }

        override fun onLocationChanged(location: Location) {
            myLocation = location
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }


    inner class MyThread:Thread{
        constructor():super(){}
        override fun run(){
            while (true){
        try {
            runOnUiThread{
                mMap.clear()
                val myPosition = LatLng(myLocation.latitude,myLocation.longitude)
                mMap.addMarker(MarkerOptions().position(myPosition).title("Me").snippet("Here is my location")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_loc)))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPosition,14f))}
            Thread.sleep(1000)}
        catch (ex:Exception){}}}}


}
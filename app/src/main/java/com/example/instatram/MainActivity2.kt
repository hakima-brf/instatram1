package com.example.instatram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instatram.data.CountriesAdapter
import com.example.instatram.data.ServiceBuilder
import com.example.instatram.data.Station
import com.example.instatram.data.StationService
import kotlinx.android.synthetic.main.activity_main2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        loadStations()

    }


    private fun loadStations() {
        //initiate the service
        val destinationService = ServiceBuilder.buildService(StationService::class.java)
        val requestCall = destinationService.getStationData()
        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<Station>> {
            override fun onResponse(call: Call<List<Station>>, response: Response<List<Station>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val stationList = response.body()!!
                    Log.d("Response", "countrylist size : ${stationList.size}")
                    country_recycler.apply {
                        setHasFixedSize(true)

                        layoutManager = GridLayoutManager(this@MainActivity2,1)
                        adapter = CountriesAdapter(response.body()!!)






                    }
                }else{
                    Toast.makeText(this@MainActivity2, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<Station>>, t: Throwable) {
                Toast.makeText(this@MainActivity2, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun station1(view: View){
        val intent = Intent(this, Camera::class.java).apply{}

        startActivity(intent)
    }





    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.exp_menu, menu)
        return true
    }

    fun go_home() {
        // Do something in response to button
        val intent = Intent(this, MainActivity::class.java).apply{}

        startActivity(intent)
    }
    fun go_map() {
        // Do something in response to button
        val intent = Intent(this, MapsActivity::class.java).apply{}

        startActivity(intent)
    }
    fun change_language() {
        // Do something in response to button
        val intent = Intent(this, Language::class.java).apply{}

        startActivity(intent)
    }
    fun change_theme() {
        // Do something in response to button
        val intent = Intent(this, Theme::class.java).apply{}

        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.item1 -> {
                this.go_home()
                true
            }
            R.id.item2 -> {
                this.go_map()
                true
            }
            R.id.item3 -> {
                this.go_home()
                true
            }
            R.id.item4 -> {
                this.go_home()
                true
            }
            R.id.subitem1 -> {
                this.change_language()
                true
            }
            R.id.subitem2 -> {
                this.change_theme()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
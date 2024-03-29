package com.mahmutalperenunal.whichcar.activity.profile

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahmutalperenunal.whichcar.R
import com.mahmutalperenunal.whichcar.activity.cardetail.DetailActivity
import com.mahmutalperenunal.whichcar.adapter.CarAdapter
import com.mahmutalperenunal.whichcar.api.RetrofitInstance
import com.mahmutalperenunal.whichcar.databinding.ActivityFavoritesBinding
import com.mahmutalperenunal.whichcar.model.NetworkConnection
import com.mahmutalperenunal.whichcar.model.car.CarDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritesBinding

    private lateinit var brands: ArrayList<String>
    private lateinit var models: ArrayList<String>

    private var userToken: String? = null

    private lateinit var sharedPreferencesAuthToken: SharedPreferences

    private val carAdapter by lazy { CarAdapter(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initialize
        brands = arrayListOf()
        models = arrayListOf()

        //get user token
        sharedPreferencesAuthToken = getSharedPreferences("authToken", MODE_PRIVATE)
        userToken = sharedPreferencesAuthToken.getString("token", null)

        checkConnection()

        getModelData()
        onClickProcess()

        //back to profileActivity
        binding.profileFavouritesBackButton.setOnClickListener { onBackPressed() }
    }


    //check connection
    private fun checkConnection() {

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { isConnected ->
            if (!isConnected) {
                AlertDialog.Builder(this, R.style.CustomAlertDialog)
                    .setTitle(R.string.no_internet_connection_title_text)
                    .setMessage(R.string.no_internet_connection_description_text)
                    .setIcon(R.drawable.without_internet)
                    .setNegativeButton(R.string.ok_text) { dialog, _ ->
                        checkConnection()
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }
        }

    }


    //get model data
    private fun getModelData() {

        setupRecyclerview()

        val retrofit = RetrofitInstance.apiFavorites

        val call: Call<List<CarDetail>> = retrofit.getCarDetailList("Token $userToken")
        call.enqueue(object : Callback<List<CarDetail>> {
            override fun onResponse(
                call: Call<List<CarDetail>>,
                response: Response<List<CarDetail>>
            ) {

                if (response.isSuccessful) {

                    binding.profileFavouritesProgressBar.visibility = View.GONE

                    response.body()?.let {
                        val size = response.body()!!.size - 1
                        for (item in 0..size) {
                            models.add(response.body()!![item].model)
                            brands.add(response.body()!![item].brand)
                            carAdapter.setData(it)
                        }
                    }

                } else {

                    Log.e("Favorites Error", response.errorBody().toString())

                    binding.profileFavouritesProgressBar.visibility = View.GONE

                }

            }

            override fun onFailure(call: Call<List<CarDetail>>, t: Throwable) {

                Log.e("Favorites Error", t.printStackTrace().toString())

                binding.profileFavouritesProgressBar.visibility = View.GONE

                Toast.makeText(
                    applicationContext,
                    R.string.operation_failed_text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    }


    //setup recyclerView
    private fun setupRecyclerview() {
        binding.profileFavoritesRecyclerView.adapter = carAdapter
        binding.profileFavoritesRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.profileFavoritesRecyclerView.setHasFixedSize(true)
    }


    //go to detailActivity
    private fun onClickProcess() {
        carAdapter.setOnItemClickListener(object : CarAdapter.OnItemClickListener {
            @SuppressLint("SetTextI18n")
            override fun onItemClick(position: Int) {

                val intent = Intent(applicationContext, DetailActivity::class.java)
                intent.putExtra("Brand", brands[position])
                intent.putExtra("Model", models[position])
                startActivity(intent)
                finish()
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

            }
        })
    }


    //back to brandsActivity
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(applicationContext, ProfileActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
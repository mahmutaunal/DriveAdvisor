package com.mahmutalperenunal.whichcar.activity.cardetail

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mahmutalperenunal.whichcar.R
import com.mahmutalperenunal.whichcar.databinding.ActivityBrandsBinding
import com.mahmutalperenunal.whichcar.activity.home.HomeActivity
import com.mahmutalperenunal.whichcar.model.NetworkConnection

class BrandsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBrandsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrandsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkConnection()

        goToModelActivity()

        //back to homeActivity
        binding.carsBackButton.setOnClickListener { onBackPressed() }
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


    //go to modelActivity
    private fun goToModelActivity() {

        binding.carsButton1.setOnClickListener {
            val intentModels = Intent(applicationContext, DetailActivity::class.java)
            intentModels.putExtra("Brand", "Audi")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton2.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "BMW")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton3.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Citroen")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton4.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Dacia")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton5.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Fiat")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton6.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Ford")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton7.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Honda")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton8.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Hyundai")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton9.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Mercedes")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton10.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Nissan")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton11.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Opel")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton12.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Peugeot")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton13.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Renault")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton14.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Seat")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton15.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Skoda")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton16.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Toyota")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton17.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Volkswagen")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.carsButton18.setOnClickListener {
            val intentModels = Intent(applicationContext, ModelsActivity::class.java)
            intentModels.putExtra("Brand", "Volvo")
            startActivity(intentModels)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    }

    //back to homeActivity
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(applicationContext, HomeActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
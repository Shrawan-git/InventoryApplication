package com.example.inventorysystem.inventoryapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    companion object {
       private const val minCost = 100
       private const val maxCost = 8000
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        fab.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }
//        "Use later"
//        val preferences = getSharedPreferences("database", Context.MODE_PRIVATE)
//        val savedName = preferences.getString("savedProductName", "This value does not exist")
//        d("shrawan", "saved message: $savedName")

  //      tvSavedProduct.text = savedName

        val products = listOf(
            Product("iPad", "shrawan", 2005, 260.50),
            Product("Pixel", "sudeep", 2006, 350.00),
            Product("Kotlin", "gunjan", 2009, 11112.00),
            Product("Laptop", "sabin", 2020, 98.60),
            Product("Mobile", "sajin", 2019, 100.60)
        )

        var totalCost = 0.0

        products.forEach {
            if (it.cost > minCost && it.cost < maxCost){
            tvProduct.append("${it.name} - ${it.owner} - ${it.yearPublished} - Rs. ${it.cost} \n\n ")
            totalCost += it.cost
        }
        }

        d("shrawan", "Total cost $totalCost")

        tvTotalCost.text = "Rs. $totalCost"

    }
}
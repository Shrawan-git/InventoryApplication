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

        val products = listOf("Building", "Car", "Truck" , "Laptop", "Mobile")

        products.forEach {
            d("shrawan","Product is: $it")
            tvProduct.append("$it \n\n ")
        }

    }
}
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

        showInexpensive()

        fab.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }

        btnFilterByPrice.setOnClickListener {
            showInexpensive()
        }
        btnFilterByName.setOnClickListener {
            showName()
        }
    }

    fun showInexpensive() {
        val products = ProductData().allProducts().filter { it.cost < 100 }
        showProducts(products)
    }

    fun showName() {
        val products =
            ProductData().allProducts().filter { it.owner.contains(AppConfig.filterByName, true) }
        showProducts(products)
    }

    //            val products = ProductData().allProducts()
//            showProducts(products)

    private fun showProducts(products: List<Product>) {

        tvProduct.text = ""

        var totalCost = 0.0

        products.forEach {
            tvProduct.append("${it.name} - ${it.owner} - ${it.yearPublished} - Rs. ${it.cost} \n\n ")
            totalCost += it.cost
        }

        d("shrawan", "Total cost $totalCost")

        tvTotalCost.text = "Rs. $totalCost"
    }

}

//        "Use later"
//        val preferences = getSharedPreferences("database", Context.MODE_PRIVATE)
//        val savedName = preferences.getString("savedProductName", "This value does not exist")
//        d("shrawan", "saved message: $savedName")

//      tvSavedProduct.text = savedName
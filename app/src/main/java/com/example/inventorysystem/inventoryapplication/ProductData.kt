package com.example.inventorysystem.inventoryapplication

class ProductData {

    fun allProducts(): List<Product>{
        return listOf(
            Product("iPad", "shrawan shakya", 2005, 260.50),
            Product("Pixel", "sudeep shakya", 2006, 1350.00),
            Product("Kotlin", "gunjan shakya", 2009, 1112.00),
            Product("Laptop", "sabin bajracharya", 2020, 98.60),
            Product("Mobile", "sajin maharjan", 2019, 185.60),
            Product("Mobile", "raju shakya", 2019, 85.60),
            Product("Mobile", "nabin thapa", 2019, 55.60),
            Product("Mobile", "ram hari", 2019, 833.60)
        )
    }
}
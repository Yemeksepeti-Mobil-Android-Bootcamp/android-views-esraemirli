package com.emirli.foodappuidesign

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    private lateinit var addBasketButton: AppCompatButton
    private lateinit var increaseQuantityButton: AppCompatImageView
    private lateinit var decreaseQuantityButton: AppCompatImageView
    private lateinit var priceTextView: AppCompatTextView
    private lateinit var quantityTextView: AppCompatTextView

    private var productQuantity = 1
    private val quantityPrice = 4.99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        addListener()
    }

    private fun initViews() {
        increaseQuantityButton = findViewById(R.id.increaseQuantityButton)
        decreaseQuantityButton = findViewById(R.id.decreaseQuantityButton)
        priceTextView = findViewById(R.id.priceTextView)
        quantityTextView = findViewById(R.id.quantityTextView)
        addBasketButton = findViewById(R.id.addBasketButton)

        printValues()
    }

    private fun addListener() {
        //Increase product quantity
        increaseQuantityButton.setOnClickListener {
            ++productQuantity
            printValues()
        }
        //Decrease product quantity
        decreaseQuantityButton.setOnClickListener {
            --productQuantity
            printValues()
        }
        // Prints a message
        addBasketButton.setOnClickListener {
            Toast.makeText(layoutInflater.context, "Sepete Eklendi", Toast.LENGTH_SHORT).show()
        }

    }

    // Prints the product quantity and price
    @SuppressLint("SetTextI18n")
    private fun printValues() {
        quantityTextView.text = "$productQuantity"
        priceTextView.text = "$" + String.format("%.2f", productQuantity * quantityPrice)
        decreaseQuantityButton.isEnabled = productQuantity > 0
    }

}
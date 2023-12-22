package com.example.beternakapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.beternakapp.databinding.ProductDetailBinding

class ProductDetail : AppCompatActivity() {
    companion object {
        const val TITLE = "title"
        const val PRICE = "price"
        const val DESC = "desc"
        const val IMG = "img"
    }

    private lateinit var binding: ProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(TITLE)
        val price = intent.getIntExtra(PRICE, 0)
        val desc = intent.getStringExtra(DESC)
        val img = intent.getStringExtra(IMG)

        binding.tvTitle.text = title
        binding.tvPrice.text = "Rp. ${price}"
        binding.tvDesc.text = desc
        Glide.with(binding.imgProduct)
            .load(img)
            .into(binding.imgProduct)

        binding.btnLogin.setOnClickListener() {
            val intentPay = Intent(this@ProductDetail, PaymentActivity::class.java)
            startActivity(intentPay)
        }
    }
}
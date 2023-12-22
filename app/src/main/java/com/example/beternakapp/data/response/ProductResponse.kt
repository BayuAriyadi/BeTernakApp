package com.example.beternakapp.data.response

import com.google.gson.annotations.SerializedName

data class ProductResponse(

	@field:SerializedName("data")
	val data: List<DataItem>
)

data class DataItem(

	@field:SerializedName("product_desc")
	val productDesc: String,

	@field:SerializedName("product_image")
	val productImage: String,

	@field:SerializedName("product_keywords")
	val productKeywords: String,

	@field:SerializedName("product_id")
	val productId: Int,

	@field:SerializedName("product_cat")
	val productCat: Int,

	@field:SerializedName("product_brand")
	val productBrand: Int,

	@field:SerializedName("product_price")
	val productPrice: Int,

	@field:SerializedName("stock")
	val stock: Int,

	@field:SerializedName("product_title")
	val productTitle: String,

	@field:SerializedName("sales")
	val sales: Int
)
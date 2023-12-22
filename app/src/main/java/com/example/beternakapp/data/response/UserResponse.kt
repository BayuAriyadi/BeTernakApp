package com.example.beternakapp.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("userId")
	val userId: Int,

	@field:SerializedName("token")
	val token: String
)

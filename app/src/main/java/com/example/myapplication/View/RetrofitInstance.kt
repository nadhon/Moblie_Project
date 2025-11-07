package com.exemple.myapplication.services

object RetrofitiInstance {
    private const val BASW_URL = "https://api.github.com/"
    val api: ApiSerice by lazy {
        retrofit.Builder()
            .baseUrl(baseUrl = BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServerce::class.java)
    }
}
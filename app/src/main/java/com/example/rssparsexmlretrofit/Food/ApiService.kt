package com.example.rssparsexmlretrofit.Food

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @get:GET("/xml/simple.xml")
    val foods : Call<BreakFastMenu>
}

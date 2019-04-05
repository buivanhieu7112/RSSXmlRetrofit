package com.example.rssparsexmlretrofit.vnexpress

import retrofit2.Call
import retrofit2.http.GET

interface ApiVnExpress {
    @get:GET("/rss/tin-moi-nhat.rss")
    val articles: Call<Feed>

    @get:GET("/rss/cuoi.rss")
    val articles_2: Call<Feed>

    @get:GET("/rss/giai-tri.rss")
    val articles_3: Call<Feed>
}

package com.example.rssparsexmlretrofit.vnexpress

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

@Suppress("DEPRECATION")
class FeedController {
    fun run() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://vnexpress.net")
            .client(OkHttpClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiVnExpress::class.java)
        val call = apiService.articles_3
        call.enqueue(object : Callback<Feed> {
            override fun onFailure(call: Call<Feed>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
                if (response.isSuccessful) {
                    val feed = response.body()
                    if (feed != null) {
                        val articles = feed.channel!!.item
                        Log.d("SIZE", articles!!.size.toString())
                        for (i in 0 until articles.size) {
                            Log.d("FEED", "index $i " + articles[i].title)
                            Log.d("FEED", "index $i " + articles[i].link)
                            Log.d("FEED", "index $i " + articles[i].pubDate)
                            Log.d("FEED", "index $i " + articles[i].guid)
                        }
                    }
                }
            }

        })
    }
}

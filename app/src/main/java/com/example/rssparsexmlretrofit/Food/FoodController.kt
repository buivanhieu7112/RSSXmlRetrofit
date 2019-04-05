package com.example.rssparsexmlretrofit.Food

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


@Suppress("DEPRECATION")
class FoodController {
    fun run() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.w3schools.com")
            .client(OkHttpClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiService::class.java)
        val call = apiService.foods
        call.enqueue(object : Callback<BreakFastMenu> {
            override fun onResponse(call: Call<BreakFastMenu>, response: Response<BreakFastMenu>) {
                if (response.isSuccessful) {
                    val breakFastMenu = response.body()
                    if (breakFastMenu != null) {
                        val foodList: MutableList<Food>? = breakFastMenu.foodList
                        Log.d("SIZE", foodList!!.size.toString())
                        for (i in 0 until foodList.size) {
                            Log.d("FOOD", "index $i " + foodList[i].name)
                            Log.d("FOOD", "index $i " + foodList[i].description)
                            Log.d("FOOD", "index $i " + foodList[i].price)
                            Log.d("FOOD", "index $i " + foodList[i].calories)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<BreakFastMenu>, t: Throwable) {
                t.printStackTrace()
                Log.e("Response fail", t.message)
            }
        })
    }
}

package com.yfrite.olymp.service

import android.util.Log
import com.yfrite.olymp.data.model.VKResponse
import com.yfrite.olymp.data.model.VKService
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.*
import java.io.IOException

class DataServiceImpl: DataService {
    private val client: OkHttpClient = OkHttpClient()
    private val servicesUrl = "https://mobile-olympiad-trajectory.hb.bizmrg.com/semi-final-data.json"

    override fun parseVKServices(): List<VKService> {
        val request = Request.Builder()
            .url(servicesUrl)
            .build()

        val vkServices: MutableList<VKService> = mutableListOf()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            vkServices.addAll(Json.decodeFromString<VKResponse>(response.body!!.string()).items)
        }

        return vkServices

//        client.newCall(request).enqueue(object: Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                Log.e("fail", e.toString())
//
//                throw e
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                vkServices.addAll(Json.decodeFromString<VKResponse>(response.body!!.string()).items)
//
//            }
//
//        })
    }
}
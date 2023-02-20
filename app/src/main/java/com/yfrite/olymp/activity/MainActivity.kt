package com.yfrite.olymp.activity

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.yfrite.olymp.App
import com.yfrite.olymp.data.model.VKService
import com.yfrite.olymp.databinding.ActivityMainBinding
import com.yfrite.olymp.fragment.ServicesFragment
import com.yfrite.olymp.recycler_adapter.VKServicesAdapter
import com.yfrite.olymp.service.DataService
import com.yfrite.olymp.service.DataServiceImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private val dataService: DataService = DataServiceImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        if(!isOnline(this)){
            if(App.servicesDao.count() == 0)
                Toast.makeText(this, "Проверьте свое интернет подключение!", Toast.LENGTH_LONG).show()
//            } else{
//                setupRecycler(App.servicesDao.all())
//            }
        } else{
//            App.servicesDao.clearTable()
            GlobalScope.launch {
//                App.servicesDao.insert(dataService.parseVKServices())
                val data: List<VKService> = dataService.parseVKServices()
                MainScope().launch {
                    setupRecycler(data)
                }
            }
        }

        setContentView(binding.root)
    }

    private fun setupRecycler(data: List<VKService>) {
        binding.vkServices.layoutManager = LinearLayoutManager(binding.root.context)
        binding.vkServices.adapter = VKServicesAdapter(data)
    }

    private fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                return true
            }
        }
        return false
    }
}
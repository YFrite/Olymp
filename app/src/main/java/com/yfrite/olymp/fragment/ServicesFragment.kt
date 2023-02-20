package com.yfrite.olymp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yfrite.olymp.data.model.VKService
import com.yfrite.olymp.databinding.FragmentServicesBinding
import com.yfrite.olymp.recycler_adapter.VKServicesAdapter
import com.yfrite.olymp.service.DataService
import com.yfrite.olymp.service.DataServiceImpl
import kotlinx.coroutines.*
import java.util.logging.Logger

class ServicesFragment : Fragment() {

    private lateinit var binding: FragmentServicesBinding
    private val dataService: DataService = DataServiceImpl()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServicesBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var data: List<VKService>

        GlobalScope.launch {
            data = dataService.parseVKServices()
            MainScope().launch {
                binding.vkServices.adapter = VKServicesAdapter(data)
            }
        }

    }
}
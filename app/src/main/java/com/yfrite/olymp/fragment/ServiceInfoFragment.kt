package com.yfrite.olymp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yfrite.olymp.databinding.FragmentServiceInfoBinding

class ServiceInfoFragment : Fragment() {

    private lateinit var binding: FragmentServiceInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServiceInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
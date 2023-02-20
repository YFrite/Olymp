package com.yfrite.olymp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.yfrite.olymp.R
import com.yfrite.olymp.databinding.ActivityServiceInfoBinding

class ServiceInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServiceInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceInfoBinding.inflate(layoutInflater)

        val extras = intent.extras
        if(extras != null){
            binding.name.text = extras.getString("name")
            binding.description.text = extras.getString("description")
            binding.link.text = extras.getString("serviceUrl")
            Glide.with(binding.root.context)
                .load(extras.getString("iconUrl"))
                .skipMemoryCache(false)
                .into(binding.icon)
        }

        setContentView(binding.root)
    }
}
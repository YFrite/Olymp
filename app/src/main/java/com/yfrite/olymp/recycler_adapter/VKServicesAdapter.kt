package com.yfrite.olymp.recycler_adapter

import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.yfrite.olymp.activity.ServiceInfoActivity
import com.yfrite.olymp.data.model.VKService
import com.yfrite.olymp.databinding.ServiceItemBinding

class VKServicesAdapter(private val vkServices: List<VKService>):
    RecyclerView.Adapter<VKServicesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ServiceItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(vkService: VKService) {
            binding.name.text = vkService.name

            Glide.with(binding.root.context)
                .load(vkService.iconUrl)
                .skipMemoryCache(false)
                .into(binding.icon)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ServiceItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = vkServices[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, ServiceInfoActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("description", item.description)
            intent.putExtra("iconUrl", item.iconUrl)
            intent.putExtra("serviceUrl", item.serviceUrl)

            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = vkServices.size
}
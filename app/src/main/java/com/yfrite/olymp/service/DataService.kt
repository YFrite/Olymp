package com.yfrite.olymp.service

import com.yfrite.olymp.data.model.VKService

interface DataService {

    fun parseVKServices(): List<VKService>
}
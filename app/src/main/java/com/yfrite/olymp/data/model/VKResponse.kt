package com.yfrite.olymp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VKResponse(
    @SerialName("items") val items: List<VKService>
)
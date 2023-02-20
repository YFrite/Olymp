package com.yfrite.olymp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@Entity(tableName = "vk_services")
data class VKService(
    @Transient @PrimaryKey val id: Int = -1,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @SerialName("icon_url") @ColumnInfo(name = "icon_url") val iconUrl: String,
    @SerialName("service_url") @ColumnInfo(name = "service_url") val serviceUrl: String
)

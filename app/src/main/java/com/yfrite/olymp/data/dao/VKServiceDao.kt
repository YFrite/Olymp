package com.yfrite.olymp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.yfrite.olymp.data.model.VKService

@Dao
interface VKServiceDao {

    @Query("SELECT * FROM vk_services")
    fun all(): List<VKService>

    @Query("SELECT COUNT(id) FROM vk_services")
    fun count(): Int

    @Query("DELETE FROM vk_services")
    fun clearTable()

    @Insert
    fun insert(services: List<VKService>)

    @Delete
    fun delete(service: VKService)
}
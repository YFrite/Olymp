package com.yfrite.olymp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yfrite.olymp.data.dao.VKServiceDao
import com.yfrite.olymp.data.model.VKService

@Database(entities = [VKService::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun vkServiceDao(): VKServiceDao
}
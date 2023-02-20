package com.yfrite.olymp

import android.app.Application
import androidx.room.Room
import com.yfrite.olymp.data.AppDatabase
import com.yfrite.olymp.data.dao.VKServiceDao

class App: Application() {
    companion object {
        lateinit var db: AppDatabase
        lateinit var servicesDao: VKServiceDao
    }
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext,
            AppDatabase::class.java, "services_db").build()

        servicesDao = db.vkServiceDao()
    }
}
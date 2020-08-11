package com.raka.productq.di.module

import android.app.Application
import androidx.room.Room
import com.raka.productq.data.database.AppDatabase
import com.raka.productq.data.database.ParametersDao
import com.raka.productq.utils.Constants.Companion.DB_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): ParametersDao {
        val instance: AppDatabase?
        synchronized(AppDatabase::class){
            instance = Room.databaseBuilder(
                app.applicationContext,
                AppDatabase::class.java, DB_NAME
            ).build()
        }
        return instance!!.parametersDao()
    }
}
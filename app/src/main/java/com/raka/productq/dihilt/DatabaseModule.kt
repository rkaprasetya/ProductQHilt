package com.raka.productq.dihilt

import android.app.Application
import androidx.room.Room
import com.raka.productq.data.database.AppDatabase
import com.raka.productq.data.database.ParametersDao
import com.raka.productq.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): ParametersDao {
        val instance: AppDatabase?
        synchronized(AppDatabase::class) {
            instance = Room.databaseBuilder(
                app.applicationContext,
                AppDatabase::class.java, Constants.DB_NAME
            ).build()
        }
        return instance!!.parametersDao()
    }
}
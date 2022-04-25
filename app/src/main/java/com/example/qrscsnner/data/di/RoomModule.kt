package com.example.qrscsnner.data.di

import android.content.Context
import androidx.room.Room
import com.example.qrscsnner.data.room.dao.ScannerDao
import com.example.qrscsnner.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context) : AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .build()
    }

    @Singleton
    @Provides
    fun provideScannerDao(appDatabase: AppDatabase): ScannerDao{
        return appDatabase.getScannerDao()
    }
}
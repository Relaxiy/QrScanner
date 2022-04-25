package com.example.qrscsnner.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.qrscsnner.data.room.dao.ScannerDao
import com.example.qrscsnner.data.room.entity.ScannerEntity
import com.example.qrscsnner.database.AppDatabase.Companion.DATABASE_VERSION

@Database(
    entities = [ScannerEntity::class],
    version = DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_VERSION = 1
    }

    abstract fun getScannerDao(): ScannerDao
}
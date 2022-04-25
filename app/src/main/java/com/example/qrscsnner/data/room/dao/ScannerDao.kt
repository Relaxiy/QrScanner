package com.example.qrscsnner.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.qrscsnner.data.room.entity.ScannerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ScannerDao {

    @Query("SELECT * FROM scanners")
    suspend fun getAllScans(): List<ScannerEntity>

    @Insert
    suspend fun saveScan(scannerEntity: ScannerEntity)
}
package com.example.qrscsnner.domain

import com.example.qrscsnner.data.room.entity.ScannerEntity
import kotlinx.coroutines.flow.Flow

interface ScannerResultRepository {

    suspend fun getScannerResults(): Flow<List<ScannerEntity>>

    suspend fun saveScannerResult(scannerEntity: ScannerEntity)
}
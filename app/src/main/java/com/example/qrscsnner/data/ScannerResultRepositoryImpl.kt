package com.example.qrscsnner.data

import com.example.qrscsnner.data.room.dao.ScannerDao
import com.example.qrscsnner.data.room.entity.ScannerEntity
import com.example.qrscsnner.domain.ScannerResultRepository
import com.example.qrscsnner.domain.ext.toScannerEntity
import com.example.qrscsnner.domain.ext.toScannerResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScannerResultRepositoryImpl @Inject constructor(
    private val scannerDao: ScannerDao
) : ScannerResultRepository {

    override suspend fun getScannerResults(): Flow<List<ScannerEntity>> {
        return flow {
            while (true) {
                emit(scannerDao.getAllScans())
                delay(1000L)
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun saveScannerResult(scannerEntity: ScannerEntity) {
        withContext(Dispatchers.IO) {
            return@withContext scannerDao.saveScan(scannerEntity)
        }
    }

}
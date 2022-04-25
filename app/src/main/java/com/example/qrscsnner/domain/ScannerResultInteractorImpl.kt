package com.example.qrscsnner.domain

import com.example.qrscsnner.domain.ext.toScannerEntity
import com.example.qrscsnner.domain.ext.toScannerResult
import com.example.qrscsnner.domain.models.ScannerResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScannerResultInteractorImpl @Inject constructor(
    private val scannerResultRepository: ScannerResultRepository
) : ScannerResultInteractor {

    override suspend fun getScannerResults(): Flow<List<ScannerResult>> {
        return flow {
            scannerResultRepository.getScannerResults().map { list ->
                list.map { scannerEntity ->
                    scannerEntity.toScannerResult()
                }
            }
        }
    }

    override suspend fun saveScannerResult(scannerResult: ScannerResult) {
        scannerResultRepository.saveScannerResult(scannerResult.toScannerEntity())
    }

}
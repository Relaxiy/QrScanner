package com.example.qrscsnner.domain.di

import com.example.qrscsnner.data.ScannerResultRepositoryImpl
import com.example.qrscsnner.domain.ScannerResultRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindScannerResultRepository(scannerResultRepositoryImpl: ScannerResultRepositoryImpl): ScannerResultRepository
}
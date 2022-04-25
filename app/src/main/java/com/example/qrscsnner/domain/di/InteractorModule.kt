package com.example.qrscsnner.domain.di

import com.example.qrscsnner.domain.ScannerResultInteractor
import com.example.qrscsnner.domain.ScannerResultInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorModule {
    @Binds
    fun bindScannerResultInteractor(scannerResultInteractorImpl: ScannerResultInteractorImpl): ScannerResultInteractor
}
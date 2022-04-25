package com.example.qrscsnner.presentation.di

import androidx.lifecycle.ViewModel
import com.example.qrscsnner.presentation.qrScan.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel) : ViewModel
}
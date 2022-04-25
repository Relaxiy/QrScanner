package com.example.qrscsnner.di

import android.content.Context
import com.example.qrscsnner.domain.di.RepositoryModule
import com.example.qrscsnner.data.di.RoomModule
import com.example.qrscsnner.domain.di.InteractorModule
import com.example.qrscsnner.presentation.di.ViewModelFactory
import com.example.qrscsnner.presentation.di.ViewModelsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RoomModule::class,
        RepositoryModule::class,
        InteractorModule::class,
        ViewModelsModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun viewModelsFactory(): ViewModelFactory
}
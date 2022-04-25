package com.example.qrscsnner.utils

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.qrscsnner.QrApplication
import com.example.qrscsnner.di.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is QrApplication -> appComponent
        else -> this.applicationContext.appComponent
    }

fun FragmentActivity.openFragment(tag: String, fragment: Fragment, id: Int){
    supportFragmentManager
        .beginTransaction()
        .replace(id, fragment, tag)
        .addToBackStack(tag)
        .commit()
}
package com.seonjk.smartdeliveryclone

import android.app.Application
import com.seonjk.smartdeliveryclone.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class SdcApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SdcApplication)
            modules(appModule)
        }
    }
}
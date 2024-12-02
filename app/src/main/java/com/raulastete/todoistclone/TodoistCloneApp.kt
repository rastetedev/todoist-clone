package com.raulastete.todoistclone

import android.app.Application
import com.raulastete.todoistclone.di.appModule
import com.raulastete.todoistclone.di.repositoryModule
import com.raulastete.todoistclone.projects.creation.projectCreationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class TodoistCloneApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TodoistCloneApp)
            modules(
                appModule + repositoryModule + projectCreationModule
            )
        }
    }
}
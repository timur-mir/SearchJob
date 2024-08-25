package home.howework.searchjob

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class App: Application() {
    init {
        instance = this
    }
    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null

        private var instance: Context? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}
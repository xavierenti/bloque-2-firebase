package com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase

import android.app.Application
import android.provider.CalendarContract.Instances
import com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Classes.Firebase.MyFirebase

class MyApp : Application(){
    companion object {
        private lateinit var Instance: MyApp
        fun get() = Instance
    }

    override fun onCreate() {
        super.onCreate()
        Instance = this
        //enviarle al firebase que la app se ha ejecutado
        MyFirebase.init(Instance)
        MyFirebase.analytics.logOpenApp()

        MyFirebase.crashlytics.logSimpleError("Subnormal error"){
            key("Subnormal Name", "Abraham")
            key("Is Subnormal", true)
            key("Anormal", 1) 
        }

    }


}
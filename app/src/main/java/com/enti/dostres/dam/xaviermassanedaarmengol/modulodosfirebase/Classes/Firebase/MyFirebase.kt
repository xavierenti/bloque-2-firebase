package com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Classes.Firebase

import android.app.Application

class MyFirebase {
    companion object{
        lateinit var analytics: MyFirebaseAnalytics
        fun init(appContect : Application){
            analytics = MyFirebaseAnalytics(appContect)
        }
    }
}
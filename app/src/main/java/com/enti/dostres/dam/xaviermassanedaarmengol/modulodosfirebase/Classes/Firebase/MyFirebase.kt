package com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Classes.Firebase

import android.app.Application

typealias FB = MyFirebase
class MyFirebase {
    companion object{
        lateinit var analytics: MyFirebaseAnalytics
        val crashlytics = MyFirebaseCrashalytics()
        lateinit var auth: MyFirebaseAuth

        fun init(appContect : Application){
            analytics = MyFirebaseAnalytics(appContect)
            auth = MyFirebaseAuth(appContect)
        }
    }
}
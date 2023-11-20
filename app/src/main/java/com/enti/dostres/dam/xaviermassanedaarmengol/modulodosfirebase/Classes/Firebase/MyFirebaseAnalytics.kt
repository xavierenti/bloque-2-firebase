package com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Classes.Firebase

import android.app.Application
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class MyFirebaseAnalytics (private val appContext : Application){
    private var analytics = FirebaseAnalytics.getInstance(appContext)

        fun logOpenApp(){
            val bundle = Bundle()
            analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, bundle)
        }
}
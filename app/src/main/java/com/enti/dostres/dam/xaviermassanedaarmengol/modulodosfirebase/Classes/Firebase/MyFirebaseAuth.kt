package com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Classes.Firebase

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class MyFirebaseAuth (val appContext: Application) {

    private val myFirebaseAuth = FirebaseAuth.getInstance()

    fun getUser():FirebaseUser?{
        return myFirebaseAuth.currentUser
    }
}
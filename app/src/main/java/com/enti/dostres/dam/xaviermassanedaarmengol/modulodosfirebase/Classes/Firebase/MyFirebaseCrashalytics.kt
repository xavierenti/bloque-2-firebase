package com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Classes.Firebase

import com.google.firebase.crashlytics.KeyValueBuilder
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.setCustomKeys
import com.google.firebase.ktx.Firebase

class MyFirebaseCrashalytics {
    private val crashalytics = Firebase.crashlytics

    fun logSimpleError(text:String, addExtraDataFun:(KeyValueBuilder.() -> Unit)? = null){
        logError(Exception(text), addExtraDataFun)
    }

    fun logError(exception: Exception, addExtraDataFun:(KeyValueBuilder.() -> Unit)? = null){
        addExtraDataFun?.let {extraDataFun ->
            val builder = KeyValueBuilder(crashalytics)
            builder.extraDataFun()
        }
        crashalytics.recordException(exception)
    }
}
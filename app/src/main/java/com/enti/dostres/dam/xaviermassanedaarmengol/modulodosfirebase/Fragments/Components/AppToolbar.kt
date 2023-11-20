package com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Fragments.Components

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Classes.Firebase.MyFirebase
import com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.R
import com.google.android.material.appbar.MaterialToolbar
import java.lang.RuntimeException

class AppToolbar:Fragment() {

    companion object{
        lateinit var Instance: AppToolbar
        fun Get() = Instance
    }

    public lateinit var toolbar: MaterialToolbar

    //Quando se crea la instancia de la classe
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance = this
    }

    //quando se tiene que crear la vista
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.component_toolbar, container,false )
        toolbar = view.findViewById(R.id.app_toolbar)
        return view
    }

    //cuando las vistas ya esctan creadas
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setOnMenuItemClickListener { menuItem ->

            when(menuItem.itemId){
                R.id.toolbar_button_test -> {
                    //throw RuntimeException("Test Crash")
                    MyFirebase.crashlytics.logSimpleError("Subnormal error"){
                        key("Subnormal Name", "Abraham")
                        key("Is Subnormal", true)

                    }
                }
            }
            true
        }


    }

}
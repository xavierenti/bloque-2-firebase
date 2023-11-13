package com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Fragments.Components

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.R
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class AppBottomBar : Fragment() {

    companion object{
        lateinit var instance: AppBottomBar

        fun Get() = instance
    }

    lateinit var bottomAppBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.component_bottombar,container,false)
        bottomAppBar = view.findViewById(R.id.app_bottombar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomAppBar.setOnItemSelectedListener {menuItem ->
        AppToolbar.Get().toolbar.title = menuItem.title
            if(menuItem.itemId != bottomAppBar.selectedItemId) {

                when (menuItem.itemId) {
                    R.id.home_bottom_bar_button -> {
                        AppNavHost.Get().navHost.navigate(R.id.transition_chat_to_home)
                    }

                    R.id.chat_bottom_bar_button -> {
                        AppNavHost.Get().navHost.navigate(R.id.transition_home_to_chat)
                    }
                }
            }

            true

        }
    }

}
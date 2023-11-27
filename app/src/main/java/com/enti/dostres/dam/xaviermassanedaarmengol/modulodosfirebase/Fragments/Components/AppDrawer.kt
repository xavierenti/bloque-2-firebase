package com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Fragments.Components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Fragments.Screens.LoguinScreen
import com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.R
import com.google.android.material.navigation.NavigationView

class AppDrawer : Fragment() {
    companion object{
        private lateinit var Instance:AppDrawer

        fun get() = Instance
    }

    lateinit var fragmentView : View

    lateinit var drawer: DrawerLayout
    lateinit var navigationDrawer: NavigationView

    override fun onCreate (SavedInstanceState:Bundle?){
        super.onCreate(SavedInstanceState)
        Instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container:ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        fragmentView = inflater.inflate(R.layout.component_navigationdrawer,container,false)

        drawer = fragmentView.findViewById(R.id.app_drawer)
        navigationDrawer = fragmentView.findViewById(R.id.navigation_drawer)

        return fragmentView
    }

    override fun onViewCreated(view:View,savedInstanceState: Bundle?){
        super.onViewCreated(view,savedInstanceState)

        navigationDrawer.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.login_drawer_button -> {

                    val loguinScreen = LoguinScreen()
                    val transaction = childFragmentManager.beginTransaction()
                    transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right)
                        .replace(R.id.reusableDialogsContainer, loguinScreen)
                        .addToBackStack(null)
                        .commit()

                    drawer.closeDrawers()
                }
            }
            true
        }

    }

    fun Open(){
        drawer.open()
    }

}
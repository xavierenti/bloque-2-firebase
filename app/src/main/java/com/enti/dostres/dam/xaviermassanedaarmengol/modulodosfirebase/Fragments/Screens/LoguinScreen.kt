package com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Fragments.Screens

import android.app.Activity.RESULT_OK
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Classes.Firebase.FB
import com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.Fragments.Components.AppDrawer
import com.enti.dostres.dam.xaviermassanedaarmengol.modulodosfirebase.R
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.android.gms.common.SignInButton
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.ktx.Firebase

class LoguinScreen:Fragment() {

    lateinit var fragmentView:View

    val usernameContainer by lazy{fragmentView.findViewById<MaterialCardView>(R.id.usernameInputContainer)}
    val usernameField by lazy{fragmentView.findViewById<TextInputLayout>(R.id.usernameInput)}

    val passwordContainer by lazy{fragmentView.findViewById<MaterialCardView>(R.id.passwordInputContainer)}
    val passwordField by lazy{fragmentView.findViewById<TextInputLayout>(R.id.passwordInput)}

    val verifyPasswordContainer by lazy{fragmentView.findViewById<MaterialCardView>(R.id.berifayPasswordInputContainer)}
    val verifyPasswordField by lazy{fragmentView.findViewById<TextInputLayout>(R.id.berifayPasswordInput)}

    val emailLoguinbutton by lazy{fragmentView.findViewById<MaterialButton>(R.id.loguinButon)}
    val registerButton by lazy{fragmentView.findViewById<MaterialButton>(R.id.registerButon)}
    val googleAuthButton by lazy{fragmentView.findViewById<SignInButton>(R.id.loguin_google_button)}


    val singInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ){res ->
        this.onSingInResult(res)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.loguin_screen, container, false)

        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailLoguinbutton.setOnClickListener{emailLoguin()}
        registerButton.setOnClickListener { startRegister() }
        googleAuthButton.setOnClickListener{googleAuth()}
    }

    private fun emailLoguin(){

    }

    private fun startRegister(){
        verifyPasswordContainer.visibility=View.VISIBLE

        emailLoguinbutton.text = getString(R.string.back_to_loguin_button)
        registerButton.text = getString(R.string.finish_register_button)

        emailLoguinbutton.setOnClickListener {

            verifyPasswordContainer.visibility = View.GONE

            emailLoguinbutton.text = getString(R.string.loguin_button)
            emailLoguinbutton.setOnClickListener { emailLoguin() }

            registerButton.text = getString(R.string.register_button)
            registerButton.setOnClickListener { startRegister() }
        }

        registerButton.setOnClickListener { endRegister() }
    }

    private fun endRegister(){

    }

    private fun googleAuth(){
        val providers= arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build(),
        AuthUI.IdpConfig.GoogleBuilder().build(),
        )
        val singInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()

        singInLauncher.launch(singInIntent)
    }

    private fun onSingInResult(result:FirebaseAuthUIAuthenticationResult){
        if(result.resultCode == RESULT_OK){

            parentFragmentManager.popBackStack()

            FB.auth.getUser()?.let { user ->

                Snackbar.make(
                    AppDrawer.get().fragmentView,
                    getString(R.string.user_loguin_message, user.displayName),
                    Snackbar.LENGTH_LONG
                ).show()

            }?:{
                FB.crashlytics.logSimpleError("Loguin Error No User"){
                    key("code", result.resultCode)
                    key("data", result.toString())
                }

                Snackbar.make(
                    AppDrawer.get().fragmentView,
                    getString(R.string.loguin_error),
                    Snackbar.LENGTH_LONG
                ).show()

            }
        }else{
            FB.crashlytics.logSimpleError("Loguin error"){
                key("code", result.resultCode)
                key("data", result.toString())
            }

            Snackbar.make(
                AppDrawer.get().fragmentView,
                getString(R.string.loguin_error),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

}
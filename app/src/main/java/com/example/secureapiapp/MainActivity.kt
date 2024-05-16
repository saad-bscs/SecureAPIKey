package com.example.secureapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin = BuildConfig.USER_LOGIN
        val userPassword = BuildConfig.USER_PASSWORD
        val apiKey = BuildConfig.API_KEY

        Log.e("USER-LOGIN: ", "" + userLogin)
        Log.e("USER-PASSWORD: ", "" + userPassword)
        Log.e("API-KEY: ",""+apiKey)
    }
}
package com.shido.ramotiontest.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.shido.ramotiontest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    companion object {
        const val showOnboarding = "SHOW_ONBOARDING"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("RAMOTION_PREFS", Context.MODE_PRIVATE)
        setContentView(R.layout.activity_main)
        setupShowOnBoarding()
    }


    private fun setupShowOnBoarding() {
        show_onboarding.isChecked = sharedPreferences.getBoolean(showOnboarding, false)

        show_onboarding.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit {
                putBoolean(showOnboarding, isChecked)
            }
        }
    }
}

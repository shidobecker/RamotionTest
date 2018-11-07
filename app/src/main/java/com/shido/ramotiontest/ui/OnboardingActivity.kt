package com.shido.ramotiontest.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.transaction
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage
import com.shido.ramotiontest.R

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        setup()
    }


    private fun setup() {
        val screen1 = PaperOnboardingPage("News", "A new way to get to the news", ContextCompat.getColor(this, R.color.onboarding1),
                android.R.drawable.btn_star, android.R.drawable.ic_dialog_email)

        val screen2 = PaperOnboardingPage("Maps", "All of you can get", ContextCompat.getColor(this, R.color.onboarding1),
                android.R.drawable.ic_btn_speak_now, android.R.drawable.ic_dialog_alert)

        val screen3 = PaperOnboardingPage("Youtube", "Videos on the demand", ContextCompat.getColor(this, R.color.onboarding1),
                android.R.drawable.btn_plus, android.R.drawable.ic_dialog_info)

        val elements = arrayListOf(screen1, screen2, screen3)

        val onBoardingFragment = PaperOnboardingFragment.newInstance(elements)

        supportFragmentManager.transaction {
            replace(R.id.container, onBoardingFragment, "PAPER_FRAG_TAG")
        }

        onBoardingFragment.setOnRightOutListener {
            val intent = Intent(this@OnboardingActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

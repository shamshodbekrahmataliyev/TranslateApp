package com.example.translateapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ingliz tilini o'rnatish tugmasi
        val englishButton: Button = findViewById(R.id.btnEnglish)
        englishButton.setOnClickListener {
            changeAppLanguage("en")
        }

        // Rus tilini o'rnatish tugmasi
        val russianButton: Button = findViewById(R.id.btnRussian)
        russianButton.setOnClickListener {
            changeAppLanguage("ru")
        }

        // O‘zbek tilini o‘rnatish tugmasi
        val uzbekButton: Button = findViewById(R.id.btnUzbek)
        uzbekButton.setOnClickListener {
            changeAppLanguage("uz")
        }
    }

    /**
     * Ilova tilini o'zgartiruvchi funksiya
     * @param languageCode - tanlangan til kodi ("en", "ru", "uz")
     */
    private fun changeAppLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration(resources.configuration)
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        // MainActivity-ni qayta ochish (til o'zgarishini qo'llash uchun)
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}

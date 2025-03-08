package com.example.sharedpreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var nom: TextView
    private lateinit var email: TextView
    private lateinit var sharedpreferences: SharedPreferences

    companion object {
        const val PREF_NAME = "mypref"
        const val NAME_KEY = "Name"
        const val EMAIL_KEY = "Email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nom = findViewById(R.id.editNom)
        email = findViewById(R.id.editEmail)
        sharedpreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)

        if (sharedpreferences.contains(NAME_KEY)) {
            nom.text = sharedpreferences.getString(NAME_KEY, "")
        }
        if (sharedpreferences.contains(EMAIL_KEY)) {
            email.text = sharedpreferences.getString(EMAIL_KEY, "")
        }
    }

    fun save(view: View) {
        val n = nom.text.toString()
        val e = email.text.toString()
        val editor = sharedpreferences.edit()
        editor.putString(NAME_KEY, n)
        editor.putString(EMAIL_KEY, e)
        editor.apply()
    }

    fun clear(view: View) {
        val editor = sharedpreferences.edit()
        editor.remove(NAME_KEY) // Supprime la clé Name
        editor.remove(EMAIL_KEY) // Supprime la clé Email
        editor.apply()

        nom.text = ""
        email.text = ""
    }

    fun get(view: View) {
        if (sharedpreferences.contains(NAME_KEY)) {
            nom.text = sharedpreferences.getString(NAME_KEY, "")
        }
        if (sharedpreferences.contains(EMAIL_KEY)) {
            email.text = sharedpreferences.getString(EMAIL_KEY, "")
        }
    }
}

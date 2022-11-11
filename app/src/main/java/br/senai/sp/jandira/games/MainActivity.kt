package br.senai.sp.jandira.games

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.createAccount.setOnClickListener {

            var openSignupActivity = Intent(this, Activity2::class.java)
            startActivity(openSignupActivity)

        }


    }
}





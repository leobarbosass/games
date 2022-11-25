package br.senai.sp.jandira.games

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.NiveisEnum
import br.senai.sp.jandira.games.model.User

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
        binding.idJoin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        if(validar()){
            val email = binding.idEmail.text.toString()
            val password = binding.idPassword.text.toString()

//            //Passo 1 = Obter instäncia do SharedPreferences
//            val dados = getSharedPreferences("dados", MODE_PRIVATE)
//            val emailShared = dados.getString("email", "Email não encontrado")
//            val passShared = dados.getString("password", "Senha não encontrada")
//
//            //verificar se os dados de autentocação estão corretos
//            if(email == emailShared && password == passShared) {
//                val openActivity3 = Intent(this, Activity3::class.java)
//
//                startActivity(openActivity3)
//            }else{
//                Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
//            }
        }

    }

    private fun validar(): Boolean {
        if(binding.idEmail.text.isEmpty()){
            binding.idEmail.error = "Email is required"
            return false
        }
        if(binding.idPassword.text.isEmpty()){
            binding.idPassword.error = "Password is required"
            return false
        }
        return true
    }


}





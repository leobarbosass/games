package br.senai.sp.jandira.games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_save){
            Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show()
            return true
        }else if (item.itemId == R.id.menu_settings){
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            return true
        }else {
            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            return true
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }
}


package br.senai.sp.jandira.games

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.senai.sp.jandira.games.model.User

class Activity2 : AppCompatActivity() {
    lateinit var editName: EditText
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editDate: EditText
    lateinit var editCity: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_2)

        //Instanciar os componentes (views) dentro do onCreate
        editName = findViewById(R.id.id_name_adress)
        editEmail = findViewById(R.id.id_text_email)
        editPassword = findViewById(R.id.id_keytwo)
        editDate = findViewById(R.id.id_date)
        editCity = findViewById(R.id.id_city)

    }

    //Classe = receita
    private fun saveUser() {
        //construção do objeto usuário:
        val user = User ()

        user.codigo = 1
        user.nome = editName.text.toString()
        user.email = editEmail.text.toString()
        user.senha = editPassword.text.toString()
        user.cidade = editCity.text.toString()

        //Gravar usuário com SharedPreferences
        //Passo 1 = Obter instäncia do SharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        //Passo 2 = Criar um editor para o arquivo
        val editor = dados.edit()

        //Passo 3 = Inserindo dados no arquivo
        editor.putInt("id", user.codigo)
        editor.putString("name", user.nome)
        editor.putString("email", user.email)
        editor.putString("password", user.senha)

        //commit(devolve um boolean) = executar gravação
        if(editor.commit()){
            Toast.makeText(this, "Usuario registrado com sucesso", Toast.LENGTH_SHORT).show()

            //Fecha a activity
            finish()
        }else{
            Toast.makeText(this, "Falha na criacao de registro do usuario", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_save){
            saveUser()
        }else if (item.itemId == R.id.menu_settings){
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            return true
        }else {
            var openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
            true
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }

}


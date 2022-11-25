package br.senai.sp.jandira.games

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import br.senai.sp.jandira.games.model.NiveisEnum
import br.senai.sp.jandira.games.model.User

class Activity2 : AppCompatActivity() {
    lateinit var editName: EditText
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editDate: EditText
    lateinit var editCity: EditText
    val user = User ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_2)

        //Instanciar os componentes (views) dentro do onCreate
        editName = findViewById(R.id.id_name_adress)
        editEmail = findViewById(R.id.id_text_email)
        editPassword = findViewById(R.id.id_keytwo)
        editDate = findViewById(R.id.id_date)
        editCity = findViewById(R.id.id_city)
        seekBar()
    }

    //Classe = receita
    private fun saveUser() {
        //construção do objeto usuário:
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


    private fun seekBar(){

        var seekBar: SeekBar
        var level: TextView = findViewById(R.id.level)
        seekBar = findViewById(R.id.seekBar)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {

                if (progress > 24 && progress < 50){

                    level.setText("basico")
                    user.nivel = NiveisEnum.BASICO
                }
                else if (progress > 49 && progress < 76){

                    level.setText("intermediario")
                    user.nivel = NiveisEnum.INTERMEDIARIO
                }
                else if (progress > 75 && progress < 101) {

                    level.setText("avancado")
                    user.nivel = NiveisEnum.AVANCADO
                }
                else  {

                    level.setText("casual")
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}


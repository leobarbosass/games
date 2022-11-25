package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import java.time.LocalDate

class User {

    var codigo = 0 //Codigo é do tipo int por isso o 0
    var nome = ""
    var email = ""
    var senha = ""
    var cidade = ""
    var foto: Bitmap? = null // para ser nulo tem que ter ?
    var sexo = "I" // no caso do char tem que passar alguma coisa || CHAR é so um caracter
    var nivel = NiveisEnum.BASICO
    var console: Console? = null

}
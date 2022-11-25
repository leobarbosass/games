package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_user")
class User {

    @PrimaryKey(autoGenerate = true) var codigo = 0

    var nome = ""
    var email = ""
    var senha = ""
    var cidade = ""
    var sexo = "I" // no caso do char tem que passar alguma coisa || CHAR é so um caracter
    var nivel = NiveisEnum.BASICO

}
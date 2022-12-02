package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_games")
class Game {

    @PrimaryKey(autoGenerate = true) var codigo = 0
    var nome = ""
    var titulo = ""
    var descricao = ""
    var estudio = ""
    var foto = ""
    @ColumnInfo (name = "ano_lancamento")var anoLancamento = ""
    var statusGame = ""
}
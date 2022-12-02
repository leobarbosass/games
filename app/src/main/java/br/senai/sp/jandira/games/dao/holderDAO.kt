package br.senai.sp.jandira.games.dao

import android.content.Context
import android.graphics.drawable.Drawable
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.holderModel

class holderDAO {

    companion object{

        fun getGames(context: Context): List<holderModel>{

            val game1 = holderModel()

            game1.codigo = 1
            game1.nome = "Tomb Raider"
            game1.descricao = "Tomb Raider é um jogo de aventura e sobrevivencia..."
            game1.empresa = "Core Design"
            game1.imagem = context.getDrawable(R.drawable.tomb)

            val game2 = holderModel()

            game2.codigo = 2
            game2.nome = "Valorant"
            game2.descricao = "Valorant é um jogo de fps criado pela riot games.."
            game2.empresa = "Riot Games"
            game2.imagem = context.getDrawable(R.drawable.valorant)

            val game3 = holderModel()

            game3.codigo = 3
            game3.nome = "Fortnite"
            game3.descricao = "Fortnite é um jogo do estilo battle royale, onde ele..."
            game3.empresa = "Epic Games"
            game3.imagem = context.getDrawable(R.drawable.fortnite)

            val holderList = listOf<holderModel>(game1, game2, game3)

            return holderList

        }
    }

}
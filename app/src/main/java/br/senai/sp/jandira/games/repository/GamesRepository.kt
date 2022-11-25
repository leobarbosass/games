package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.GamesDB
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.User

class GamesRepository(context: Context) {
    private val db = GamesDB.getDatabase(context).gamesDAO()

    fun saveUser(user: User) : Long{
        return db.save(user)
    }
    fun save (game : Game): Long {
        return db.save(game)
    }
    fun update (game: Game) : Int{
        return db.update(game)
    }
    fun delete(game: Game):Int{
        return db.delete(game)
    }
    fun getAll() : List<Game>{
        return db.getAll()
    }
    fun getContactById(Id:Int):Game{
        return db.getGameById(Id)
    }



}
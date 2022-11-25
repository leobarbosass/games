package br.senai.sp.jandira.games.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.User

@Database(entities = [User::class, Console::class, Game::class], version = 1)
abstract class GamesDB : RoomDatabase() {
    abstract fun gamesDAO() : GamesDAO
    companion object{
        private lateinit var  instance : GamesDB

        fun getDatabase(context: Context):GamesDB{
            if(!::instance.isInitialized) {
                instance = Room.databaseBuilder(context, GamesDB::class.java, "db_games")
                    .allowMainThreadQueries().build()
            }
            return instance
        }

    }
}
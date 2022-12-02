package br.senai.sp.jandira.games

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.adapter.holderAdapter
import br.senai.sp.jandira.games.dao.holderDAO
import br.senai.sp.jandira.games.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {

    lateinit var rvGames: RecyclerView
    lateinit var adapterHolder: holderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        rvGames = findViewById(R.id.rv_games_V)

        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        adapterHolder = holderAdapter(this)
        adapterHolder.updateHolderAdapterList(holderDAO.getGames(this))

        rvGames.adapter = adapterHolder


    }
}
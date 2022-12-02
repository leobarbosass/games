package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.holderModel

class holderAdapter(val context: Context) : RecyclerView.Adapter<holderAdapter.HolderPt>() {

    private var holderAdapterList = listOf<holderModel>()

    fun updateHolderAdapterList(holderList: List<holderModel>){

        this.holderAdapterList = holderList
        notifyDataSetChanged()
    }

    class HolderPt(view: View): RecyclerView.ViewHolder(view) {

        val textEmpresa = view.findViewById<TextView>(R.id.idEmpresa)
        val textNomeGame = view.findViewById<TextView>(R.id.idNomeGame)
        val textDescicao = view.findViewById<TextView>(R.id.idDescricao)
        val imageHolder = view.findViewById<ImageView>(R.id.idImagem)

        fun bind(holdermodel : holderModel){

            textEmpresa.text = holdermodel.empresa
            textNomeGame.text = holdermodel.nome
            textDescicao.text = holdermodel.descricao
            imageHolder.setImageDrawable(holdermodel.imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderPt {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_holder, parent,  false)
        return HolderPt(view)
    }

    override fun onBindViewHolder(holder: HolderPt, position: Int) {

        holder.bind(holderAdapterList.get(position))

    }

    override fun getItemCount(): Int {

        return holderAdapterList.size

    }

}
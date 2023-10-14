package com.example.androidworrkshop.ui

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.androidworrkshop.R
import com.example.androidworrkshop.databinding.ItemMatchBinding
import com.example.androidworrkshop.model.Match
import com.example.androidworrkshop.model.MatchDetail
import com.example.androidworrkshop.model.MatchDetailsMap

class MatchAdapter(private val context: Context, private val MatchDetails : MutableList<Match>) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {


    class ViewHolder(binding: ItemMatchBinding) : RecyclerView.ViewHolder(binding.root){
        val Team1 = binding.cvTeam1
        val Team2 = binding.cvTeam2
        val time = binding.cvTime
        val location = binding.location
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMatchBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount(): Int {
        return MatchDetails.size
    }

    override fun onBindViewHolder(holder: MatchAdapter.ViewHolder, position: Int) {
       val model = MatchDetails[position]
        holder.Team1.text = model.matchInfo.team1?.teamSName
        holder.Team2.text = model.matchInfo.team2?.teamSName
        holder.time.text = model.matchInfo.status
        holder.location.text = model.matchInfo.venueInfo?.city

        holder.itemView.setOnClickListener{
           if(model.matchInfo.state=="Complete"){
               val intent=Intent(context,MatchInfoActivity::class.java)
               intent.putExtra("matchId",model.matchInfo.matchId)
               context.startActivity(intent)
           }else{
               Toast.makeText(context, "No Scorecard available", Toast.LENGTH_SHORT).show()
           }
       }
    }

}
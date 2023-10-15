package com.example.androidworrkshop.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.androidworrkshop.R
import com.example.androidworrkshop.databinding.ItemMatchBinding
import com.example.androidworrkshop.model.Match

class MatchAdapter(private val context: Context, private val MatchDetails : List<Match>, private val listener : OnItemClickListener) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemMatchBinding) : RecyclerView.ViewHolder(binding.root){
//        val Team1 = binding.cvTeam1
//        val Team2 = binding.cvTeam2
        val Team = binding.team
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
        holder.Team.text = model.matchInfo.team1.teamName + model.matchInfo.team2.teamName
//        holder.Team1.text = model.matchInfo.team1.teamName
//        holder.Team2.text = model.matchInfo.team2.teamName
        holder.time.text = model.matchInfo.status
        holder.location.text = model.matchInfo.venueInfo.city
    }

}
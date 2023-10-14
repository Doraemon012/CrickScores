package com.example.androidworrkshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidworrkshop.R
import com.example.androidworrkshop.databinding.ActivityMatchListBinding
import com.example.androidworrkshop.di.Resource
import com.example.androidworrkshop.model.Match
import com.example.androidworrkshop.model.MatchInfo
import com.example.androidworrkshop.model.MatchInfoX
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchListActivity : AppCompatActivity() {

    lateinit var binding : ActivityMatchListBinding
    lateinit var viewModel : MainViewModel
    private var MatchInfo : MatchInfo ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_list)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getShops()

        setObservers()
    }

    private fun setObservers(){
        viewModel.performFetchMatchesStatus.observe(this, Observer {
            when(it.status){
                Resource.Status.LOADING -> {
                    Log.e("setObservers", "Loading")
//                    binding.progressBar.visibility = View.VISIBLE
                }
                Resource.Status.EMPTY -> {
                    Log.e("setObservers", "Empty")
//                    binding.progressBar.visibility = View.GONE
//                    binding.emptyDialog.visibility = View.VISIBLE
                }
                Resource.Status.SUCCESS -> {
                    Log.e("setObservers", "Success")
//                    binding.progressBar.visibility = View.GONE
//                    binding.emptyDialog.visibility = View.GONE
//                    ImageList = it.data
                    Log.e("Result",it.data.toString())
                    MatchInfo=it.data
                    SetUpRecyclerView()
                }
                Resource.Status.ERROR -> {
                    Log.e("setObservers", it.error.toString())
//                    binding.progressBar.visibility = View.GONE
//                    binding.emptyDialog.visibility = View.VISIBLE
                    Toast.makeText(this, it.error.toString(), Toast.LENGTH_SHORT).show()
                }

                else -> {}
            }
        })
    }

    fun SetUpRecyclerView(){
        var x=0
        var matchList:MutableList<MatchInfoX> = arrayListOf()
        Log.e("kkkk",MatchInfo.toString())
        MatchInfo?.matchDetails?.forEach{
//            for((key,match) in it.matchDetailsMap)
            Log.e("llll",it.matchDetailsMap.toString())
        }
//        var adapter=MatchAdapter(this,)
    }

}
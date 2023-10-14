package com.example.androidworrkshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidworrkshop.R
import com.example.androidworrkshop.di.Resource
import com.example.androidworrkshop.model.leanback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchInfoActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel
    lateinit var  scoreCard:leanback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_info)

        val receivedIntent = intent
        var matchId = receivedIntent.getStringExtra("matchId")

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        if (matchId != null) {
            viewModel.getMatchScore(matchId)
        }else{
            matchId="75451"
            viewModel.getMatchScore(matchId)
        }

        setObservers()
    }

    private fun setObservers() {
        viewModel.performFetchMatchesScoreStatus.observe(this, Observer {
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
                    scoreCard= it.data!!
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
}
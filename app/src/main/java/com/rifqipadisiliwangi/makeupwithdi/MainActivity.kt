package com.rifqipadisiliwangi.makeupwithdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rifqipadisiliwangi.makeupwithdi.databinding.ActivityMainBinding
import com.rifqipadisiliwangi.makeupwithdi.view.MakeupAdapter
import com.rifqipadisiliwangi.makeupwithdi.viewmodel.ViewModelMakeup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var makeUpAdapter : MakeupAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setVmAdapter()
    }

    fun setVmAdapter(){
        val viewModel = ViewModelProvider(this).get(ViewModelMakeup::class.java)
        viewModel.callApiMakeup()
        viewModel.getliveDataMakeup().observe(this,{
            makeUpAdapter = MakeupAdapter(it)
            if (it!= null)
                binding.rvItem.layoutManager = GridLayoutManager(this,2)
            binding.rvItem.adapter = MakeupAdapter(it)
        })
    }
}
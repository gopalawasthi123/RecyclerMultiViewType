package com.example.recyclermultiviewtype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclermultiviewtype.data.MultiViewAdapter
import com.example.recyclermultiviewtype.data.MultiViewDiffUtilAdapter
import com.example.recyclermultiviewtype.factory.ItemFactoryImplementation
import com.example.recyclermultiviewtype.viewmodels.AnimalViewModel

class MainActivity : AppCompatActivity() {

    private var adapter : MultiViewAdapter ?= null
    private var utilAdapter : MultiViewDiffUtilAdapter ?= null
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel : AnimalViewModel by viewModels()
        viewModel.getAnimalList()

        recyclerView = findViewById(R.id.recyclerView)
        var layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    //    adapter = MultiViewAdapter(ItemFactoryImplementation());
        utilAdapter = MultiViewDiffUtilAdapter(ItemFactoryImplementation())

        viewModel.catList.observe(this){
            it.let { utilAdapter?.submitList(it)  }
        }

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = utilAdapter

    }
}
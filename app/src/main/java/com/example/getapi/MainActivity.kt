package com.example.getapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.getapi.network.Api
import com.example.getapi.post.PostAdapter
import com.example.getapi.post.PostViewModel

class MainActivity : AppCompatActivity() {

    lateinit var api: Api
    lateinit var MyViewModel: PostViewModel
    lateinit var Adapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MyViewModel=ViewModelProvider(this).get(PostViewModel::class.java)
        MyViewModel.GetAllData.observe(this, Observer{data->
            val recycle=findViewById<RecyclerView>(R.id.getapiRV)
            Adapter= PostAdapter(data)
            recycle.adapter=Adapter
            MyViewModel.getPost()
        })
    }
}



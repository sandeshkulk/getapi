package com.example.getapi.comments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.getapi.post.PostViewModel
import com.example.getapi.R

class CommentsActivity : AppCompatActivity() {

    lateinit var MyViewModel: CommentsViewModel          //MyVM
    lateinit var Adapter: CommentsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        MyViewModel= ViewModelProvider(this).get(CommentsViewModel::class.java)
        MyViewModel.GetAllDataWithId.observe(this, Observer { data ->
            val recycle = findViewById<RecyclerView>(R.id.commentlayoutRV)
            Adapter = CommentsAdapter(data)
            recycle.adapter = Adapter
        })
        val id=intent.getIntExtra("id",0)
        MyViewModel.getComment(id)
    }
}

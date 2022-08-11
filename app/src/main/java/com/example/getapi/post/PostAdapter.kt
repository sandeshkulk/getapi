package com.example.getapi.post

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getapi.R
import com.example.getapi.comments.CommentsActivity

class PostAdapter(private val data: List<PostModel>):RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val position=view.findViewById<TextView>(R.id.position)
        val title=view.findViewById<TextView>(R.id.title)
        val body=view.findViewById<TextView>(R.id.body)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        val holder= ViewHolder(view)

        //click listener implementation

        view.setOnClickListener {
            val bundle=Bundle().apply {
                putInt("id", data[holder.adapterPosition].id)
                Log.d("hey",data[holder.adapterPosition].id.toString())
            }
            val intent = Intent(view.context, CommentsActivity::class.java)
            intent.putExtras(bundle)
            view.context.startActivity(intent)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data[position]
        holder.position.text="Id: " +position.toString()
        holder.title.text="title: "+  data.title
        holder.body.text="body: " + data.body
    }

    override fun getItemCount(): Int {
        return data.size

    }

}
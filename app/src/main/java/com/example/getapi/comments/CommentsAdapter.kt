package com.example.getapi.comments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getapi.R

class CommentsAdapter(private val data: List<CommentsModel>): RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val positionwithid=view.findViewById<TextView>(R.id.positionwithId)
        val name=view.findViewById<TextView>(R.id.titlewithId)
        val email=view.findViewById<TextView>(R.id.email)
        val bodywithid=view.findViewById<TextView>(R.id.bodywithId)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.comments_item_list,parent,false)
        val holder= ViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data[position]
        holder.positionwithid.text="Id: "+ position.toString()
        holder.name.text="Name: "+ data.name
        holder.email.text="Email: "+ data.email
        holder.bodywithid.text="Comment: "+ data.body

    }

    override fun getItemCount(): Int {
        return data.size

    }


}
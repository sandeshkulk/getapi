package com.example.getapi.comments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.getapi.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CommentsViewModel: ViewModel() {

    val GetAllDataWithId = MutableLiveData<List<CommentsModel>>()

    fun getComment(id:Int) {
        val comments = Api().getInstance().getJsonPostDataWithId(id)
        comments.enqueue(object : Callback<List<CommentsModel>> {
            override fun onResponse(
                call: Call<List<CommentsModel>>,
                response: Response<List<CommentsModel>>
            ) {
                GetAllDataWithId.postValue(response.body()!!)

            }

            override fun onFailure(call: Call<List<CommentsModel>>, t: Throwable) {

            }
        })
    }
}
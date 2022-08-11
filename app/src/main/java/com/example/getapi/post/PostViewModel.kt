package com.example.getapi.post


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.getapi.network.Api
import com.example.getapi.comments.CommentsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {


    val GetAllData = MutableLiveData<List<PostModel>>()
    //val getalldatawithId = MutableLiveData<List<CommentsModel>>()

    init {
        getPost()
    }

    fun getPost() {
        val posts= Api().getInstance().getAllData()
        posts.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: retrofit2.Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                GetAllData.postValue(response.body()!!)

            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {

            }
        })
    }

//    fun detcomment(id:Int) {
//        val da= Api().getInstance().getJsonPostDataWithId(id)
//        da.enqueue(object : Callback<List<CommentsModel>> {
//            override fun onResponse(
//                call: Call<List<CommentsModel>>,
//                response: Response<List<CommentsModel>>
//            ) {
//                getalldatawithId.postValue(response.body()!!)
//                var k = response.body()!!.size
//                Log.d("add", response.body()!!.toString() + k)
//            }
//
//            override fun onFailure(call: Call<List<CommentsModel>>, t: Throwable) {
//                Log.d("add", "nodata")
//            }
//        })
//    }
}
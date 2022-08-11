package com.example.getapi.network

import com.example.getapi.comments.CommentsModel
import com.example.getapi.post.PostModel
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface Jsoninfo {
    @GET("posts")
    fun getAllData(): Call<List<PostModel>>

    @GET("posts/{id}/comments")
    fun getJsonPostDataWithId(
        @Path(
            value = "id",
            encoded = true
        ) id: Int
    ): Call<List<CommentsModel>>
}


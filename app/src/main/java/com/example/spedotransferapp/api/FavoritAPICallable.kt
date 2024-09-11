package com.example.spedotransferapp.api

import retrofit2.Call
import retrofit2.http.*

interface FavoriteApiService {

    @GET("/api/v1/customer/favorites")
    fun getFavorites(@Header("Authorization") token: String): Call<List<FavoritesResponse>>

    @POST("/api/v1/customer/favorites")
    fun addFavorite(
        @Header("Authorization") token: String,
        @Body request: FavoritesRequest
    ): Call<Void>

    @DELETE("/api/v1/customer/favorites/delete")
    fun deleteFavorite(
        @Header("Authorization") token: String,
        @Path("favouriteId") id: Int
    ): Call<Void>
}

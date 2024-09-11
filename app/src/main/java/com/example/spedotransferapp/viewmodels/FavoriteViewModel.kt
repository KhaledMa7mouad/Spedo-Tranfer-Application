package com.example.spedotransferapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spedotransferapp.api.RetrofitInstance
import com.example.spedotransferapp.api.FavoritesRequest
import com.example.spedotransferapp.api.FavoritesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel : ViewModel() {
    var favoriteList by mutableStateOf<List<FavoritesResponse>>(emptyList())
        private set

    fun getFavorites(token: String) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.getFavorites(token).execute()
                }
                if (response.isSuccessful) {
                    favoriteList = response.body() ?: emptyList()
                }
            } catch (e: Exception) {
                // Handle the exception appropriately (e.g., show a message to the user)
            }
        }
    }

    fun addFavorite(token: String, fullName: String, accountNumber: String) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    // Use FavoritesRequest instead of AddFavoriteRequest
                    RetrofitInstance.api.addFavorite(token, FavoritesRequest(fullName, accountNumber)).execute()
                }
                if (response.isSuccessful) {
                    getFavorites(token)
                }
            } catch (e: Exception) {

            }
        }
    }

    fun deleteFavorite(token: String, favouriteId: Int) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.deleteFavorite(token, favouriteId).execute()
                }
                if (response.isSuccessful) {
                    getFavorites(token)
                }
            } catch (e: Exception) {
            }
        }
    }
}

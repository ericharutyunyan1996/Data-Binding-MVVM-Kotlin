package com.erikharutyunyan.databindingmvvm.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.erikharutyunyan.databindingmvvm.Adapters.UserAdapter
import com.erikharutyunyan.databindingmvvm.model.Users
import com.google.gson.Gson
import io.conciergemobile.conciergemobile.carrentservices.Network.UsersApiFactory
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import org.json.JSONArray

class UserViewModel : BaseViewModel() {
    val users = MutableLiveData<MutableList<Users>>()
    val userAdapter = UserAdapter()

    fun getUsers(context: Context): MutableLiveData<MutableList<Users>> {
        var liveData = MutableLiveData<JSONArray>()
        viewModelScope.plus(errorHandler).launch {
            val response = UsersApiFactory().getCurrentUsers(context).await()
            if (response.isSuccessful) {
                val responseJsonArray = JSONArray(response.body()!!.string())
                val data = ArrayList<Users>()
                for (i in 0 until responseJsonArray.length()) {
                    data.add(
                        Gson().fromJson<Users>(
                            responseJsonArray.get(i).toString(),
                            Users::class.java
                        )
                    )
                }
                Log.i("response", "response: $data")
                users.value = data
                liveData.value = responseJsonArray

            } else {
                val responseJsonArray = JSONArray(response.errorBody()!!.string())
                liveData.value = responseJsonArray
            }
        }
        return users
    }
}
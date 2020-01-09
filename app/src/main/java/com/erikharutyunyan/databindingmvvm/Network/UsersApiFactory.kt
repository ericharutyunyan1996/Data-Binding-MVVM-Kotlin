package io.conciergemobile.conciergemobile.carrentservices.Network

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsersApiFactory {
    private var api: UsersApi? = null

    private fun getApi(context: Context): UsersApi {
        if (api == null) {
            return retrofit(context).create(UsersApi::class.java)
        }
        return api!!
    }

    fun getCurrentUsers(context: Context): Deferred<Response<ResponseBody>> {
        return getApi(context).getUsers()
    }


    fun updateApi(context: Context) {
        api = retrofit(context).create(UsersApi::class.java)
    }

    fun retrofit(context: Context): Retrofit {
        return Retrofit.Builder().client(OkHttpClient().newBuilder().build())
            .baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(
                GsonConverterFactory.create()
            )
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
    }
}
package io.conciergemobile.conciergemobile.carrentservices.Network

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface UsersApi {

    @GET("users")
    fun getUsers(): Deferred<Response<ResponseBody>>


}
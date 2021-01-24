package com.kys.daggerhiltclean.framework.datasource.network.retrofit

import com.kys.daggerhiltclean.framework.datasource.network.model.ArticleNetworkEntity
import retrofit2.http.GET

interface ResultRetrofit {

    @GET("default/dynamodb-writer/")
    suspend fun get(): ArticleNetworkEntity
}
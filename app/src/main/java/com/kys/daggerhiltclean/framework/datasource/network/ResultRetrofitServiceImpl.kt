package com.kys.daggerhiltclean.framework.datasource.network

import com.kys.daggerhiltclean.framework.datasource.network.model.ArticleNetworkEntity
import com.kys.daggerhiltclean.framework.datasource.network.retrofit.ResultRetrofit

class ResultRetrofitServiceImpl
constructor(
    private val blogRetrofit: ResultRetrofit
) : ResultRetrofitService {

    override suspend fun get(): ArticleNetworkEntity {
        return blogRetrofit.get()
    }
}
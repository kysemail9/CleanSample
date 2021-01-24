package com.kys.daggerhiltclean.framework.datasource.network

import com.kys.daggerhiltclean.framework.datasource.network.model.ArticleNetworkEntity

interface ResultRetrofitService {
    suspend fun get(): ArticleNetworkEntity
}
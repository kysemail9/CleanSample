package com.kys.daggerhiltclean.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArticleNetworkEntity(
        @SerializedName("results")
        @Expose
        val results: List<NetworkResult>
)
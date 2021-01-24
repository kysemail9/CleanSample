package com.kys.daggerhiltclean.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NetworkResult(
        @SerializedName("created_at") @Expose val created_at: String,
        @SerializedName("price") @Expose val price: String,
        @SerializedName("name") @Expose val name: String,
        @SerializedName("uid") @Expose val uid: String,
        @SerializedName("image_ids") @Expose val image_ids: List<String>,
        @SerializedName("image_urls") @Expose val image_urls: List<String>,
        @SerializedName("image_urls_thumbnails") @Expose val image_urls_thumbnails: List<String>
)
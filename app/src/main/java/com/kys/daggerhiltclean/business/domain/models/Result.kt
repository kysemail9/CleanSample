package com.kys.daggerhiltclean.business.domain.models

data class Result(
        val created_at: String,
        val price: String,
        val name: String,
        val uid: String,
        val image_ids: List<String>,
        val image_urls: List<String>,
        val image_urls_thumbnails: List<String>
)
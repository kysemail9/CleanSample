package com.kys.daggerhiltclean.business.data.network

import com.kys.daggerhiltclean.business.domain.models.Result

interface NetworkDataSource {
    suspend fun get(): List<Result>
}
package com.kys.daggerhiltclean.business.data.cache

import com.kys.daggerhiltclean.business.domain.models.Result

interface CacheDataSource {
    suspend fun insert(result: Result): Long
    suspend fun insertList(result: List<Result>)
    suspend fun get(): List<Result>
}
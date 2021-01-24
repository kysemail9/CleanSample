package com.kys.daggerhiltclean.business.interactors

import com.kys.daggerhiltclean.business.data.cache.CacheDataSource
import com.kys.daggerhiltclean.business.data.network.NetworkDataSource
import com.kys.daggerhiltclean.business.domain.models.Result
import com.kys.daggerhiltclean.business.domain.state.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetResults
constructor(
        private val cacheDataSource: CacheDataSource,
        private val networkDataSource: NetworkDataSource
) {

    /**
     * Show loading
     * 1. Get results from network
     * 2. Insert results into cache
     * 3. Show List<Results>
     */
    suspend fun execute(): Flow<DataState<List<Result>>> = flow {
        emit(DataState.Loading)
        //delay(1000)
        val networkResults = networkDataSource.get()
        cacheDataSource.insertList(networkResults)
        val cachedResults = cacheDataSource.get()
        emit(DataState.Success(cachedResults))
    }
}

















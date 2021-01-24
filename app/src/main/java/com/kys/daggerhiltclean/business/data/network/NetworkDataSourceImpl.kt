package com.kys.daggerhiltclean.business.data.network

import com.kys.daggerhiltclean.business.domain.models.Result
import com.kys.daggerhiltclean.framework.datasource.network.ResultRetrofitService
import com.kys.daggerhiltclean.framework.datasource.network.mappers.NetworkMapper

class NetworkDataSourceImpl
constructor(
        private val blogRetrofitService: ResultRetrofitService,
        private val networkMapper: NetworkMapper
) : NetworkDataSource {

    override suspend fun get(): List<Result> {
        return networkMapper.mapFromEntityList(blogRetrofitService.get().results)
    }
}
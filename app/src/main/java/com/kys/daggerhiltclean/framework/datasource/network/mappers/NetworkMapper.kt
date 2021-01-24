package com.kys.daggerhiltclean.framework.datasource.network.mappers

import com.kys.daggerhiltclean.business.domain.models.Result
import com.kys.daggerhiltclean.business.domain.util.EntityMapper
import com.kys.daggerhiltclean.framework.datasource.network.model.NetworkResult
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<NetworkResult, Result> {

    override fun mapFromEntity(entity: NetworkResult): Result {

        return Result(
                created_at = entity.created_at,
                price = entity.price,
                name = entity.name,
                uid = entity.uid,
                image_ids = entity.image_ids,
                image_urls = entity.image_urls,
                image_urls_thumbnails = entity.image_urls_thumbnails
        )
    }

    override fun mapToEntity(domainModel: Result): NetworkResult {
        return NetworkResult(
                created_at = domainModel.created_at,
                price = domainModel.price,
                name = domainModel.name,
                uid = domainModel.uid,
                image_ids = domainModel.image_ids,
                image_urls = domainModel.image_urls,
                image_urls_thumbnails = domainModel.image_urls_thumbnails
        )
    }

    fun mapFromEntityList(entities: List<NetworkResult>): List<Result> {
        return entities.map { mapFromEntity(it) }
    }
}



















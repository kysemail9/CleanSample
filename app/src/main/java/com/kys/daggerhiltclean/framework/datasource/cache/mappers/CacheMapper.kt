package com.kys.daggerhiltclean.framework.datasource.cache.mappers

import com.kys.daggerhiltclean.business.domain.models.*
import com.kys.daggerhiltclean.business.domain.util.EntityMapper
import com.kys.daggerhiltclean.framework.datasource.cache.model.ResultCacheEntity
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<ResultCacheEntity, Result> {

    override fun mapFromEntity(entity: ResultCacheEntity): Result {
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

    override fun mapToEntity(domainModel: Result): ResultCacheEntity {
        return ResultCacheEntity(
                created_at = domainModel.created_at,
                price = domainModel.price,
                name = domainModel.name,
                uid = domainModel.uid,
                image_ids = domainModel.image_ids,
                image_urls = domainModel.image_urls,
                image_urls_thumbnails = domainModel.image_urls_thumbnails
        )
    }

    fun mapFromEntityList(entities: List<ResultCacheEntity>): List<Result> {
        return entities.map { mapFromEntity(it) }
    }
}












package com.kys.daggerhiltclean.framework.datasource.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kys.daggerhiltclean.framework.datasource.cache.model.ResultCacheEntity

@Dao
interface ResultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(resultEntity: ResultCacheEntity): Long

    @Query("SELECT * FROM results")
    suspend fun get(): List<ResultCacheEntity>

}
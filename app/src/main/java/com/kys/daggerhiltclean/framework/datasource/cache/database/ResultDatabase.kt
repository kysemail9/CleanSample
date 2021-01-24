package com.kys.daggerhiltclean.framework.datasource.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kys.daggerhiltclean.framework.datasource.cache.model.ResultCacheEntity

@Database(entities = [ResultCacheEntity::class ], version = 2)
abstract class ResultDatabase: RoomDatabase() {

    abstract fun resultDao(): ResultDao

    companion object{
        const val DATABASE_NAME: String = "result_db_test"
    }
}
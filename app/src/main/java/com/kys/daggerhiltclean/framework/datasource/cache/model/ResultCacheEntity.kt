package com.kys.daggerhiltclean.framework.datasource.cache.model

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@TypeConverters(RequestConverter::class)
@Entity(tableName = "results")
data class ResultCacheEntity(

        @ColumnInfo(name = "created_at") var created_at: String = "",
        @ColumnInfo(name = "price") var price: String = "",
        @ColumnInfo(name = "name") var name: String = "",

        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "uid") var uid: String = "",

        @ColumnInfo(name = "image_ids") var image_ids: List<String> = emptyList(),
        @ColumnInfo(name = "image_urls") var image_urls: List<String> = emptyList(),
        @ColumnInfo(name = "image_urls_thumbnails") var image_urls_thumbnails: List<String> = emptyList()


        /*@SerializedName("created_at") @Expose val created_at: String,
        @SerializedName("price") @Expose val price: String,
        @SerializedName("name") @Expose val name: String,
        @SerializedName("uid") @Expose val uid: String,
        @SerializedName("image_ids") @Expose val image_ids: List<String>,
        @SerializedName("image_urls") @Expose val image_urls: List<String>,
        @SerializedName("image_urls_thumbnails") @Expose val image_urls_thumbnails: List<String>
        */
)

class RequestConverter {
    @TypeConverter
    fun fromCountryLangList(value: List<String>): String {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCountryLangList(value: String): List<String> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }
}




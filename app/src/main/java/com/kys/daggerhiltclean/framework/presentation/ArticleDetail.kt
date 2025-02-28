package com.kys.daggerhiltclean.framework.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleDetail(
        val detail: String,
        val url: String
) : Parcelable {

}
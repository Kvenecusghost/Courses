package com.example.courses.card

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameId: Int,
    val numberOfClasses: Int,
    @DrawableRes val imageId: Int
)

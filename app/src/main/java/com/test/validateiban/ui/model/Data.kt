package com.test.validateiban.ui.model

data class Data(
    val bankName: String,
    val bic: String,
    val bics: List<Bic>,
    val blz: String,
    val countryCode: String,
    val location: String,
    val page: Int,
    val pageCount: Int
)
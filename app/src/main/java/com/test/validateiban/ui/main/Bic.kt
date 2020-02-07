package com.test.validateiban.ui.main

data class Bic(
    val bankName: String,
    val bicCode: String,
    val bicCodeOther: List<Any>,
    val blz: String,
    val countryCode: String,
    val countryId: String,
    val id: String,
    val location: String
)
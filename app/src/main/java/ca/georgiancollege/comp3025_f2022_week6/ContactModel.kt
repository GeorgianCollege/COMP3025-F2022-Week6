package ca.georgiancollege.comp3025_f2022_week6

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContactModel(
    val FullName: String,
    val ContactNumber: String,
    val EmailAddress: String)

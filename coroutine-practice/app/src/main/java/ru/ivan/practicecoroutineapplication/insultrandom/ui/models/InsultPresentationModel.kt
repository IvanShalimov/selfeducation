package ru.ivan.practicecoroutineapplication.insultrandom.ui.models

import com.fasterxml.jackson.annotation.JsonProperty

class InsultPresentationModel(
    @JsonProperty("insult")  val insult: String,
    @JsonProperty("created") private val created: String,
    @JsonProperty("createdBy") private val createdBy: String,
)
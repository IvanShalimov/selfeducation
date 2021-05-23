package ru.ivan.practicecoroutineapplication.insultrandom.ui.repository.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * {
 * "number": "123",
 * "language": "en",
 * "insult": "You're a failed abortion whose birth certificate is an apology from the condom factory.",
 * "created": "2018-10-24 06:52:02",
 * "shown": "2688",
 * "createdby": "someone",
 * "active": "1",
 * "comment": "Sourced from some website"
 * }
 */
class InsultAPIModel(
    @JsonProperty("number") val number: String,
    @JsonProperty("language")  val language: String,
    @JsonProperty("insult")  val insult: String,
    @JsonProperty("created")  val created: String,
    @JsonProperty("shown")  val shown: String,
    @JsonProperty("createdby")  val createdBy: String?,
    @JsonProperty("active")  val active: String,
    @JsonProperty("comment")  val comment: String
)
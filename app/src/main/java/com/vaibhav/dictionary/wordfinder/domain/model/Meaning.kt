package com.vaibhav.dictionary.wordfinder.domain.model

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String,
)

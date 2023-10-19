package com.vaibhav.dictionary.wordfinder.domain.model

import com.vaibhav.dictionary.wordfinder.data.remote.dto.MeaningDto

data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String,
    val sourceUrls: List<String>,
    val word: String
)

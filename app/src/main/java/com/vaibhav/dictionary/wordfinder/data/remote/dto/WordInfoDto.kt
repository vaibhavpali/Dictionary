package com.vaibhav.dictionary.wordfinder.data.remote.dto

import com.vaibhav.dictionary.wordfinder.data.local.entity.WordInfoEntity
import com.vaibhav.dictionary.wordfinder.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic,
            word = word
        )
    }
}
package com.vaibhav.dictionary.wordfinder.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vaibhav.dictionary.wordfinder.domain.model.Meaning
import com.vaibhav.dictionary.wordfinder.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    @PrimaryKey
    val id: Int? = null,
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            word = word,
            phonetic = phonetic,
            meanings = meanings
        )
    }
}

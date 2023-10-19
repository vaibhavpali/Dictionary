package com.vaibhav.dictionary.wordfinder.domain.usecase

import com.vaibhav.dictionary.core.util.Resource
import com.vaibhav.dictionary.wordfinder.domain.model.WordInfo
import com.vaibhav.dictionary.wordfinder.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(private val repository: WordInfoRepository) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word);
    }
}
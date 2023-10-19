package com.vaibhav.dictionary.wordfinder.domain.repository

import com.vaibhav.dictionary.core.util.Resource
import com.vaibhav.dictionary.wordfinder.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}
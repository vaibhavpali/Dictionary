package com.vaibhav.dictionary.wordfinder.data.repository

import com.vaibhav.dictionary.core.util.Resource
import com.vaibhav.dictionary.wordfinder.data.local.WordInfoDao
import com.vaibhav.dictionary.wordfinder.data.remote.DictionaryApi
import com.vaibhav.dictionary.wordfinder.domain.model.WordInfo
import com.vaibhav.dictionary.wordfinder.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(private val api: DictionaryApi, private val infoDao: WordInfoDao) :
    WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfoDb = infoDao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfoDb))

        try {
            val remoteWordInfo = api.getWordInfo(word)
            infoDao.deleteWordInfos(remoteWordInfo.map { it.word })
            infoDao.insertWordInfos(remoteWordInfo.map { it.toWordInfoEntity() })


        } catch (e: HttpException) {
            emit(Resource.Error("Something went wrong!!", data = wordInfoDb))
        } catch (e: IOException) {
            emit(Resource.Error("Could connect to internet!!", data = wordInfoDb))
        }
        val updatedWordInfo = infoDao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(updatedWordInfo))
    }
}
package com.vaibhav.dictionary.wordfinder.presentation

import androidx.lifecycle.ViewModel
import com.vaibhav.dictionary.wordfinder.domain.usecase.GetWordInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(private val getWordInfo: GetWordInfo): ViewModel() {
}
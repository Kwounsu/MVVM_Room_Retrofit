package com.example.mvvm_room_retrofit

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    fun insert(word: Word) {
        wordDao.insert(word)
    }

    fun clear() {
        wordDao.deleteAll()
    }
}
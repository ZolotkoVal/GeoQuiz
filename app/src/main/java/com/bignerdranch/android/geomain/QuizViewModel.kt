package com.bignerdranch.android.geomain

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
class QuizViewModel : ViewModel() {

    var currentIndex = 0
    var correctCount = 0
    public val questionBank = listOf(Question(R.string.question_australia,true, false),
        Question(R.string.question_oceans, true, false),
        Question(R.string.question_mideast, false, false),
        Question(R.string.question_africa, false, false),
        Question(R.string.question_americas, true, false),
        Question(R.string.question_asia, true, false)
        )
    val currentQuestionAnswer: Boolean get() = questionBank[currentIndex].answer
    val currentQuestionText: Int get() = questionBank[currentIndex].textResId
    val questionsSize: Int get() = questionBank.size
    val resultScore: String get() = "Результат: $correctCount"
    fun moveToNext() {
        currentIndex = (currentIndex + 1) %questionBank.size
    }
    fun score(){
        correctCount += 1
    }
}
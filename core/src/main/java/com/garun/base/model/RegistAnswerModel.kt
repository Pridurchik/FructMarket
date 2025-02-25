package com.garun.base.model

sealed class RegistAnswerModel(
    val msg: String
) {

    data class Success(
        val message: String
    ) : RegistAnswerModel(msg = message)

    data class Error(
        val message: String
    ) : RegistAnswerModel(msg = message)

}
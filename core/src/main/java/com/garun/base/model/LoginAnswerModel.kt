package com.garun.base.model

sealed class LoginAnswerModel(
    val msg: String
) {

    data class Success(
        val message: String
    ) : LoginAnswerModel(msg = message)

    data class Error(
        val message: String
    ) : LoginAnswerModel(msg = message)

}
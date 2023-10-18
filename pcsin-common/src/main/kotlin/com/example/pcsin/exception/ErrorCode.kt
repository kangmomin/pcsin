package com.example.pcsin.exception

enum class ErrorCode(
    val msg: String,
    val code: Int
) {
    // USER
    USER_NOT_FOUND("유저를 찾을 수 없습니다.", 404),
    USER_ID_NOT_FOUND("아이디 혹은 비밀번호를 찾을 수 없습니다.", 404),
    USER_ALREADY_EXIST("이미 존재하는 아이디입니다.", 409),

    INTERNAL_SERVER_ERROR("서버에 문제가 발생하였습니다", 500),
}

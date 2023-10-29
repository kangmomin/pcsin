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

    EXPIRED_TOKEN("로그인 세션이 만료되었습니다.", 400),
    INVALID_TOKEN("토큰이 정상적이지 않습니다.", 400),
    JSON_NOT_READABLE("필수 인자가 전달되지 않았습니다.", 400),
    
    POST_NOT_SAVED("글이 작성되지 않았습니다.", 400),

    UNAUTHORIZED("로그인 정보가 없습니다.", 401),
}

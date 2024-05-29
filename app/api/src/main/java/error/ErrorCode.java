package error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //global
    INTERNAL_SERVER_ERROR(500, "GLOBAL-001", "서버에 오류가 발생하였습니다."),
    INPUT_INVALID_VALUE_ERROR(400, "GLOBAL-002", "잘못된 입력 값입니다."),
    INPUT_INVALID_TYPE_ERROR(400, "GLOBAL-003", "잘못된 입력 타입입니다."),
    REQUEST_PARAMETER_NOT_FOUND_ERROR(400, "GLOBAL-004", "입력 파라미터가 존재하지 않습니다."),
    REQUEST_PARAMETER_TYPE_NOT_MATCH_ERROR(400, "GLOBAL-005", "입력 파라미터의 타입이 올바르지 않습니다."),

    //user
    USER_NOT_FOUND_EXCEPTION(403, "USER-001", "존재하지 않는 사용자입니다.");


    private final int status;
    private final String code;
    private final String message;
}

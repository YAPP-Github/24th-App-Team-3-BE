package org.example.error;

import org.example.exception.BusinessError;

public enum GenreError implements BusinessError {
    ENTITY_NOT_FOUND_ERROR {
        @Override
        public int getHttpStatus() {
            return 404;
        }

        @Override
        public String getErrorCode() {
            return "GER-001";
        }

        @Override
        public String getClientMessage() {
            return "존재하지 않은 장르입니다.";
        }

        @Override
        public String getLogMessage() {
            return "요청 값이 잘못 처리되었습니다.";
        }
    },
}

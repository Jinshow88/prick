package com.games.prick.common.swagger.opendata;

public class FlagSwaggerDescription {

    public static final String FLAG_DESCRIPTION =

            "<strong>서버 내역을 불러옵니다.</strong>" +
                    "<p>로그인이 필요한 기능입니다. 상단 Authorize 에 토큰값을 입력 후 이용해주세요.</p>" +
                    "<p>-------------------------------------------------</p>" +
                    "<p>01. reservationBeforeResultSetList : 예약중인 글램핑 리스트를 불러옵니다.</p>" +
                    "<p>02. reservationCompleteResultSetList : 이용완료된 글램핑 리스트를 불러옵니다.</p>" +
                    "<p>03. reservationCancelResultSetList : 예약취소한 글램핑 리스트를 불러옵니다.</p>"
            ;

    public static final String FLAG_RESPONSE_ERROR_CODE =

            "<strong>발생 가능한 에러코드</strong>" +
                    "<p>CU - 미 로그인 (400)</p>" +
                    "<p>DBE - 데이터베이스 에러 (500)</p>"
            ;

}

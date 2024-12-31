package com.example.demo.web.model.response;

import com.example.demo.model.FindUserIdData;


public record FindUserIdResponse(
        FindUserIdData findUserIdData,
        boolean success
) {

    public static FindUserIdResponse fail() {
        return new FindUserIdResponse(
                null,
                true
        );
    }

    public static FindUserIdResponse successful(FindUserIdData findUserIdData) {
        return new FindUserIdResponse(
                findUserIdData,
                true
        );
    }
}

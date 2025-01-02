package com.example.AttachNet.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class LoginReponse {
    private String token;

    private long expiresIn;

}

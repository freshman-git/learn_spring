package com.example.demo.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ResultEnumCode {

    MATCH(2000),
    NOAP(2001);

    private Integer code;
}

package com.web2.pos.model.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author Abdul Rozak
 * @since 10/28/20
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse<T> {

    private Integer code;

    private String status;

    private T data;

}

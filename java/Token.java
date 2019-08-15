package com.htzs.pms;

import lombok.Data;

/**
 * @author: Earle
 * @createdDate: 2019-8-15
 * @updatedDate:
 */
@Data // 使用了lombok 插件
public class Token {

    private int errcode;

    private String access_token;

    private String errmsg;

    private int expires_in;

}

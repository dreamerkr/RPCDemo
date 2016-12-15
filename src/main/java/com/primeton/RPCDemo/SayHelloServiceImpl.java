/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年12月15日 下午4:29:14
 *******************************************************************************/


package com.primeton.RPCDemo;

public class SayHelloServiceImpl implements SayHelloService {

    @Override
    public String sayHello(String msg) {
        if("hello".equals(msg)){
            return "hello client";
        }else{
            return "bye bye";
        }
    }
}

/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年12月15日 下午4:30:23
 *******************************************************************************/


package com.primeton.RPCDemo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * TODO 服务消费者
 *
 * @author wangzhao (mailto:wangzhao@primeton.com)
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        
        //构造需要调用的方法
        String interfaceName = SayHelloService.class.getName();
        Method method = SayHelloService.class.getMethod("sayHello", 
                java.lang.String.class);
        Object[] argments = {"hello"};
        
        //发送调用信息到服务器端，调用相应的服务
        Socket socket = new Socket("127.0.0.1",1234);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeUTF(interfaceName);
        outputStream.writeUTF(method.getName());
        outputStream.writeObject(method.getParameterTypes());
        outputStream.writeObject(argments);
        System.out.println("发送信息到服务端，发送的信息为:"+argments[0]);
        
        //服务返回的结果
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Object object = inputStream.readObject();
        System.out.println("服务返回的结果为"+object);
    }
}
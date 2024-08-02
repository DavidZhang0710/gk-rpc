package com.david.easyrpc.server;

import com.david.easyrpc.Request;
import com.david.easyrpc.common.utils.ReflectionUtils;

public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(service.getTarget(), service.getMethod(), request.getParameters());
    }
}

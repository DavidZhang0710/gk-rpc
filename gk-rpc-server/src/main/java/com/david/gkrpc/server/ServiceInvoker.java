package com.david.gkrpc.server;

import com.david.gkrpc.Request;
import com.david.gkrpc.common.utils.ReflectionUtils;

public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(service.getTarget(), service.getMethod(), request.getParameters());
    }
}

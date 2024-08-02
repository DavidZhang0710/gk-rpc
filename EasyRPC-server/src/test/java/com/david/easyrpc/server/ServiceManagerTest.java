package com.david.easyrpc.server;

import com.david.easyrpc.Request;
import com.david.easyrpc.ServiceDescriptor;
import com.david.easyrpc.common.utils.ReflectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ServiceManagerTest {
    ServiceManager sm;

    @Before
    public void init() {
        sm = new ServiceManager();
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void lookup() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestInterface.class);

        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, methods[0]);
        Request request = new Request();
        request.setService(sdp);

        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);

        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);
    }
}
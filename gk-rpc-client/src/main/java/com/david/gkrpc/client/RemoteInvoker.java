package com.david.gkrpc.client;

import com.david.gkrpc.Request;
import com.david.gkrpc.Response;
import com.david.gkrpc.ServiceDescriptor;
import com.david.gkrpc.codec.Decoder;
import com.david.gkrpc.codec.Encoder;
import com.david.gkrpc.transport.TransportClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class RemoteInvoker implements InvocationHandler {
    private Class clazz;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;
    public RemoteInvoker(Class clazz, Encoder encoder, Decoder decoder, TransportSelector selector) {
        this.clazz = clazz;
        this.encoder = encoder;
        this.decoder = decoder;
        this.selector = selector;

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = new Request();
        request.setService(ServiceDescriptor.from(clazz, method));
        request.setParameters(args);

        Response response = invokeRemote(request);

        if (response == null || response.getCode()!= 0) {
            throw new IllegalStateException("fail to invoke remote: " + response);
        }
        return response.getData();
    }

    private Response invokeRemote(Request request) {
        TransportClient client = null;
        Response response = new Response();
        try {
            client = selector.select();
            byte[] outBytes = encoder.encode(request);
            InputStream receive = client.write(new ByteArrayInputStream(outBytes));
            byte[] inBytes = IOUtils.readFully(receive, receive.available());
            response = decoder.decode(inBytes, Response.class);
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
            response = new Response();
            response.setCode(1);
            response.setMessage("RpcClient got error: " + e.getClass() + ": " + e.getMessage());
        } finally {
            if (client != null) {
                selector.release(client);
            }
        }
        return response;
    }
}

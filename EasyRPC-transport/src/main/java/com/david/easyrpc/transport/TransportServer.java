package com.david.easyrpc.transport;

public interface TransportServer {
    void init(int port, RequestHandler handler);
    void start();
    void stop();
}

package com.david.gkrpc.transport;

public interface TransportServer {
    void init(int port, RequestHandler handler);
    void start();
    void stop();
}

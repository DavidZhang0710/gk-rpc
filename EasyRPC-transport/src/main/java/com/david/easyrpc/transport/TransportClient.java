package com.david.easyrpc.transport;

import com.david.easyrpc.Peer;

import java.io.InputStream;

public interface TransportClient {
    void connect(Peer peer);
    InputStream write(InputStream data);
    void close();
}

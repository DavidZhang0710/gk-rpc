package com.david.easyrpc.server;

import com.david.easyrpc.codec.Decoder;
import com.david.easyrpc.codec.Encoder;
import com.david.easyrpc.codec.JSONDecoder;
import com.david.easyrpc.codec.JSONEncoder;
import com.david.easyrpc.transport.HTTPTransportServer;
import com.david.easyrpc.transport.TransportServer;
import lombok.Data;

@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}

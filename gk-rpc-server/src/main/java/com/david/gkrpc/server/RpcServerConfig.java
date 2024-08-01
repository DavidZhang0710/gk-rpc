package com.david.gkrpc.server;

import com.david.gkrpc.codec.Decoder;
import com.david.gkrpc.codec.Encoder;
import com.david.gkrpc.codec.JSONDecoder;
import com.david.gkrpc.codec.JSONEncoder;
import com.david.gkrpc.transport.HTTPTransportServer;
import com.david.gkrpc.transport.TransportServer;
import lombok.Data;

@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}

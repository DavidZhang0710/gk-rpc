package com.david.gkrpc.client;

import com.david.gkrpc.Peer;
import com.david.gkrpc.codec.Decoder;
import com.david.gkrpc.codec.Encoder;
import com.david.gkrpc.codec.JSONDecoder;
import com.david.gkrpc.codec.JSONEncoder;
import com.david.gkrpc.transport.HTTPTransportClient;
import com.david.gkrpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoder = JSONEncoder.class;
    private Class<? extends Decoder> decoder = JSONDecoder.class;
    private Class<? extends TransportSelector> transportSelector = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1", 3000));
}

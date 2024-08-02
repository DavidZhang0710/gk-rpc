package com.david.easyrpc.client;

import com.david.easyrpc.Peer;
import com.david.easyrpc.codec.Decoder;
import com.david.easyrpc.codec.Encoder;
import com.david.easyrpc.codec.JSONDecoder;
import com.david.easyrpc.codec.JSONEncoder;
import com.david.easyrpc.transport.HTTPTransportClient;
import com.david.easyrpc.transport.TransportClient;
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

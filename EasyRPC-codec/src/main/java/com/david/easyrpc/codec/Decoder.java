package com.david.easyrpc.codec;

public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}

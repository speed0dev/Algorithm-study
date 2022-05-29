package com.data.map.net;

@FunctionalInterface
public interface IAct<T,R> {
    R act(T t);
    default void doAct(){

    }
}

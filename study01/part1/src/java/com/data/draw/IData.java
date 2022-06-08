package com.data.draw;

@FunctionalInterface
public interface IData<T> {
    public T call(T d);
}

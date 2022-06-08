package com.data.draw;

import java.awt.*;

@FunctionalInterface
public interface IDraw<T, R> {
    R draw(T d, Graphics g);

    default void draw_(){

    }
}

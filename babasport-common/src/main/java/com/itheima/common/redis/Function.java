package com.itheima.common.redis;

/**
 *
 * @param <E>
 *            代表输入
 * @param <T>
 *            代表输出
 */
public interface Function<E, T> {
    public T callBack(E e);
}

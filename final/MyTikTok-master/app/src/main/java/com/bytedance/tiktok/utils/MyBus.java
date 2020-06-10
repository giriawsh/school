package com.bytedance.tiktok.utils;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class MyBus {
    private static volatile MyBus instance;
    private Subject<Object, Object> bus;

    private MyBus() {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    public static MyBus getDefault() {
        if (instance == null) {
            synchronized (MyBus.class) {
                instance = new MyBus();
            }
        }
        return instance;
    }

    public void post(Object object) {
        bus.onNext(object);
    }
    //接收
    public <T> Observable toObservable(Class<T> eventType) {
        return bus.ofType(eventType);
    }

}

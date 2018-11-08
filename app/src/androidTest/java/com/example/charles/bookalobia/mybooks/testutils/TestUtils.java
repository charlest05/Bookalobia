package com.example.charles.bookalobia.mybooks.testutils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

public class TestUtils {

    public static <T> T getValue(final LiveData<T> liveData) throws InterruptedException {
        final Object[] data = new Object[1];
        final CountDownLatch latch = new CountDownLatch(1);

        Observer<T> observer = new Observer<T>() {
            @Override
            public void onChanged(@Nullable T t) {
                data[0] = t;
                latch.countDown();
                liveData.removeObserver(this);
            }
        };

        liveData.observeForever(observer);
        latch.await(2, TimeUnit.SECONDS);

        return (T) data[0];
    }
}

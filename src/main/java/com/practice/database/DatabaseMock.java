package com.practice.database;

import com.practice.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ravikiran_gorthi on 6/7/17.
 */
public class DatabaseMock {

    private static final AtomicInteger counter = new AtomicInteger();
    public static List<User> getUsers() {
        return new ArrayList<User>(
                Arrays.asList(
                        new User(counter.incrementAndGet(), "Daenerys Targaryen"),
                        new User(counter.incrementAndGet(), "John Snow"),
                        new User(counter.incrementAndGet(), "Arya Stark"),
                        new User(counter.incrementAndGet(), "Cersei Baratheon")));
    }
}

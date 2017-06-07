package com.practice.service;

import com.practice.database.DatabaseMock;
import com.practice.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    private final AtomicInteger counter = new AtomicInteger();
    private List<User> users = DatabaseMock.getUsers();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByName(String name) {
        for (User user : users){
            if (user.getUsername().equals(name)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void create(User user) {
        user.setId(getNextId());
        users.add(user);
    }

    @Override
    public void update(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    @Override
    public void delete(int id) {
        User user = findById(id);
        users.remove(user);
    }

    @Override
    public boolean exists(User user) {
        return findByName(user.getUsername()) != null;
    }

    private int getNextId() {
        Integer[] ids = new Integer[users.size()];
        for(int i=0;i<users.size();i++) {
            ids[i] = users.get(i).getId();
        }
        Arrays.sort(ids);

        return ids[ids.length-1]+1;
    }
}
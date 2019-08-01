package com.qaprosoft.carina.demo.db.services.impl;

import com.qaprosoft.carina.demo.db.ConnectionFactory;
import com.qaprosoft.carina.demo.db.mappers.UserMapper;
import com.qaprosoft.carina.demo.db.models.User;
import com.qaprosoft.carina.demo.db.services.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User create(User user) {
        return ConnectionFactory.executeQuery(UserMapper.class, userMapper -> {
            userMapper.create(user);
            return user;
        });
    }

    @Override
    public User retrieveById(Long id) {
        return ConnectionFactory.executeQuery(UserMapper.class, userMapper -> userMapper.findById(id));
    }

    @Override
    public User update(User user) {
        return ConnectionFactory.executeQuery(UserMapper.class, userMapper -> {
            userMapper.update(user);
            return user;
        });
    }

    @Override
    public void remove(User user) {
        ConnectionFactory.execute(UserMapper.class, userMapper -> userMapper.delete(user));
    }

}

package com.qaprosoft.carina.demo.db.services;

import com.qaprosoft.carina.demo.db.models.User;

public interface UserService {

    User create(User user);

    User retrieveById(Long id);

    User update(User user);

    void remove(User user);

}

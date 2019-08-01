package com.qaprosoft.carina.demo.db.services.impl;

import com.qaprosoft.carina.demo.db.ConnectionFactory;
import com.qaprosoft.carina.demo.db.mappers.UserPreferenceMapper;
import com.qaprosoft.carina.demo.db.models.UserPreference;
import com.qaprosoft.carina.demo.db.services.UserPreferenceService;

public class UserPreferenceServiceImpl implements UserPreferenceService {

    @Override
    public UserPreference create(UserPreference userPreference) {
        return ConnectionFactory.executeQuery(UserPreferenceMapper.class, userPreferenceMapper -> {
            userPreferenceMapper.create(userPreference);
            return userPreference;
        });
    }

}

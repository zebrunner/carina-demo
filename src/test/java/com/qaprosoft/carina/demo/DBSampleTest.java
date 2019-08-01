/*
 * Copyright 2013-2019 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.db.mappers.UserMapper;
import com.qaprosoft.carina.demo.db.mappers.UserPreferenceMapper;
import com.qaprosoft.carina.demo.db.models.User;
import com.qaprosoft.carina.demo.db.models.User.Status;
import com.qaprosoft.carina.demo.utils.ConnectionFactory;
import com.qaprosoft.carina.demo.db.models.UserPreference;

import java.util.UUID;

/**
 * This sample shows how create DB test.
 * 
 * @author qpsdemo
 */
public class DBSampleTest extends AbstractTest {
	
	private UserMapper userMapper;

	private UserPreferenceMapper userPreferenceMapper;

	@BeforeMethod
	public void setup() {
		userMapper = ConnectionFactory.getUserMapper();
		userPreferenceMapper = ConnectionFactory.getUserPreferenceMapperMapper();
	}
	
	private static User USER = new User() {
		{
			setUsername("bmarley" + UUID.randomUUID());
			setFirstName("Bob");
			setLastName("Marley");
			setStatus(Status.ACTIVE);
		}
	};
	
	private static UserPreference USER_PREFERENCE = new UserPreference() {
		{
			setName(Name.DEFAULT_DASHBOARD);
			setValue("Default");
		}
	};
	
	@Test
	public void createUser() {
		userMapper.createUser(USER);
		checkUser(userMapper.getUserById(USER.getId()));
	}
	
	@Test(dependsOnMethods="createUser")
	public void createUserPreference() {
		USER_PREFERENCE.setUserId(USER.getId());
		userPreferenceMapper.createUserPreference(USER_PREFERENCE);
		User user = userMapper.getUserById(USER.getId());
		checkUserPreference(user.getPreferences().get(0));
	}
	
	@Test(dependsOnMethods="createUserPreference")
	public void updateUser() {
		USER.setUsername("rjohns");
		USER.setFirstName("Roy");
		USER.setLastName("Johns");
		USER.setStatus(Status.INACTIVE);
		userMapper.updateUser(USER);
		checkUser(userMapper.getUserById(USER.getId()));
	}
	
	@Test(dependsOnMethods="updateUser")
	public void deleteUser() {
		userMapper.deleteUser(USER);
		assertNull(userMapper.getUserById(USER.getId()));
	}
	
	private void checkUser(User user) {
        assertEquals(user.getUsername(), USER.getUsername(), "User name must match");
        assertEquals(user.getFirstName(), USER.getFirstName(), "First name must match");
        assertEquals(user.getLastName(), USER.getLastName(), "Last name must match");
        assertEquals(user.getEmail(), USER.getEmail(), "Email must match");
    }
	
	private void checkUserPreference(UserPreference userPreference) {
        assertEquals(userPreference.getName(), USER_PREFERENCE.getName(), "Preference name must match");
        assertEquals(userPreference.getValue(), USER_PREFERENCE.getValue(), "Preference value must match");
        assertEquals(userPreference.getUserId(), USER_PREFERENCE.getUserId(), "Preference user id must match");
    }
}

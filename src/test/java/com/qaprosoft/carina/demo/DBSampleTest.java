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

import com.qaprosoft.carina.demo.db.services.UserPreferenceService;
import com.qaprosoft.carina.demo.db.services.UserService;
import com.qaprosoft.carina.demo.db.services.impl.UserPreferenceServiceImpl;
import com.qaprosoft.carina.demo.db.services.impl.UserServiceImpl;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.db.models.User;
import com.qaprosoft.carina.demo.db.models.User.Status;
import com.qaprosoft.carina.demo.db.models.UserPreference;

import java.util.UUID;

/**
 * This sample shows how create DB test.
 * 
 * @author qpsdemo
 */
public class DBSampleTest extends AbstractTest {
	
	private final UserService userService;
	private final UserPreferenceService userPreferenceService;

	public DBSampleTest() {
		this.userService = new UserServiceImpl();
		this.userPreferenceService = new UserPreferenceServiceImpl();
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
		USER = userService.create(USER);
		User user = userService.retrieveById(USER.getId());
		checkUser(user);
	}
	
	@Test(dependsOnMethods="createUser")
	public void createUserPreference() {
		USER_PREFERENCE.setUserId(USER.getId());
		USER_PREFERENCE = userPreferenceService.create(USER_PREFERENCE);
		User user = userService.retrieveById(USER.getId());
		checkUserPreference(user.getPreferences().get(0));
	}
	
	@Test(dependsOnMethods="createUserPreference")
	public void updateUser() {
		USER.setUsername("rjohns");
		USER.setFirstName("Roy");
		USER.setLastName("Johns");
		USER.setStatus(Status.INACTIVE);
		USER = userService.update(USER);
		User user = userService.retrieveById(USER.getId());
		checkUser(user);
	}
	
	@Test(dependsOnMethods="updateUser")
	public void deleteUser() {
		userService.remove(USER);
		User user = userService.retrieveById(USER.getId());
		assertNull(user);
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

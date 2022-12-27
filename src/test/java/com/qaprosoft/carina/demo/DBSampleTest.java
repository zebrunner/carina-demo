/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
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

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.db.DB;
import com.qaprosoft.carina.demo.db.mappers.UserMapper;
import com.qaprosoft.carina.demo.db.mappers.UserPreferenceMapper;
import com.qaprosoft.carina.demo.db.models.User;
import com.qaprosoft.carina.demo.db.models.User.Status;
import com.qaprosoft.carina.demo.db.models.UserPreference;
import com.qaprosoft.carina.demo.utils.ConnectionFactory;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * This sample shows how create DB test.
 * 
 * @author qpsdemo
 */
public class DBSampleTest implements IAbstractTest {

	private static User USER = new User() {
		{
			setUsername("bmarley");
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

	@DataProvider(parallel = true, name = "DP1")
	public static Object[][] dataprovider() {
		return new Object[][] {
				{ DB.MYSQL },
				{ DB.PSQL } };
	}

	@Test(dataProvider = "DP1")
	@TestLabel(name = "feature", value = "database")
	public void createUser(DB db) {
		Optional<SqlSessionFactory> ssf = ConnectionFactory.getSqlSessionFactory(db);
		Assert.assertNotEquals(ssf, Optional.empty(), "There should be SQL session factory");
		try (SqlSession session = ssf.get().openSession(true)) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			userMapper.create(USER);
			checkUser(userMapper.findById(USER.getId()));
		}
	}

	@Test(dependsOnMethods = "createUser", dataProvider = "DP1")
	@TestLabel(name = "feature", value = "database")
	public void createUserPreference(DB db) {
		Optional<SqlSessionFactory> ssf = ConnectionFactory.getSqlSessionFactory(db);
		Assert.assertTrue(ssf.isPresent(), "There should be SQL session factory");
		try (SqlSession session = ssf.get().openSession(true)) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			UserPreferenceMapper userPreferenceMapper = session.getMapper(UserPreferenceMapper.class);
			USER_PREFERENCE.setUserId(USER.getId());
			userPreferenceMapper.create(USER_PREFERENCE);
			checkUserPreference(userMapper.findById(USER.getId()).getPreferences().get(0));
		}
	}

	@Test(dependsOnMethods = "createUserPreference", dataProvider = "DP1")
	@TestLabel(name = "feature", value = "database")
	public void updateUser(DB db) {
		Optional<SqlSessionFactory> ssf = ConnectionFactory.getSqlSessionFactory(db);
		Assert.assertTrue(ssf.isPresent(), "There should be SQL session factory");
		try (SqlSession session = ssf.get().openSession(true)) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			USER.setUsername("rjohns");
			USER.setFirstName("Roy");
			USER.setLastName("Johns");
			USER.setStatus(Status.INACTIVE);
			userMapper.update(USER);
			checkUser(userMapper.findById(USER.getId()));
		}
	}

	@Test(dependsOnMethods = "updateUser", dataProvider = "DP1")
	@TestLabel(name = "feature", value = "database")
	public void deleteUser(DB db) {
		Optional<SqlSessionFactory> ssf = ConnectionFactory.getSqlSessionFactory(db);
		Assert.assertTrue(ssf.isPresent(), "There should be SQL session factory");
		try (SqlSession session = ssf.get().openSession(true)) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			userMapper.delete(USER);
			assertNull(userMapper.findById(USER.getId()));
		}
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

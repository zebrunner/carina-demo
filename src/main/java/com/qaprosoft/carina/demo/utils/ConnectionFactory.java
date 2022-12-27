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
package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.demo.db.DB;
import com.qaprosoft.carina.demo.db.mappers.UserMapper;
import com.qaprosoft.carina.demo.db.mappers.UserPreferenceMapper;
import com.zebrunner.carina.utils.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static final Map<DB, SqlSessionFactory> SESSION_FACTORY_POOL = new ConcurrentHashMap<>();

	static {
		for (DB database : DB.values()) {
			try {
				if (!isExists(database.getAlias())) {
					LOGGER.debug("Error when try to create factory for database '{}' in env '{}'", database.getAlias(),
							Configuration.get(Configuration.Parameter.ENV));
					continue;
				}
				SqlSessionFactory sessionFactory = createSessionFactory(database.getAlias());
				SESSION_FACTORY_POOL.put(database, sessionFactory);
			} catch (Exception e) {
				LOGGER.error("Error when try to create factory for database in env '{}' with alias '{}'",
						Configuration.get(Configuration.Parameter.ENV), database.getAlias());
			}
		}
	}

	private static boolean isExists(String alias) {
		return !StringUtils.isEmpty(Configuration.getEnvArg("db.url", alias));
	}

	private static SqlSessionFactory createSessionFactory(String alias) throws IOException {
		Properties properties = new Properties();
		properties.setProperty("db.driver", Configuration.getEnvArg("db.driver", alias));
		properties.setProperty(Configuration.Parameter.DB_URL.getKey(),
				Configuration.getEnvArg(Configuration.Parameter.DB_URL, alias));
		properties.setProperty(Configuration.Parameter.DB_USERNAME.getKey(),
				Configuration.getEnvArg(Configuration.Parameter.DB_USERNAME, alias));
		properties.setProperty(Configuration.Parameter.DB_PASSWORD.getKey(),
				Configuration.getEnvArg(Configuration.Parameter.DB_PASSWORD, alias));

		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		return builder.build(reader, Configuration.get(Configuration.Parameter.ENV) + "." + alias, properties);
	}

	public static Optional<SqlSessionFactory> getSqlSessionFactory(DB db) {
		return Optional.ofNullable(SESSION_FACTORY_POOL.get(db));
	}

	public static UserMapper getUserMapper(SqlSessionFactory sqlSessionFactory) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			return sqlSession.getMapper(UserMapper.class);
		}
	}

	public static UserPreferenceMapper getUserPreferenceMapperMapper(SqlSessionFactory sqlSessionFactory) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			return sqlSession.getMapper(UserPreferenceMapper.class);
		}
	}
}

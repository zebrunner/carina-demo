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
package com.qaprosoft.carina.demo.db;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConnectionFactory {

	private static SqlSessionFactory factory;

	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static <T> void execute(Class<T> mapperClass, Consumer<T> executor) {
		executeQuery(mapperClass, mapper -> {
			executor.accept(mapper);
			return null;
		});
	}

	public static <T, R> R executeQuery(Class<T> mapperClass, Function<T, R> executor) {
		R result;
		try (SqlSession session = ConnectionFactory.openSession()) {
			T mapper = session.getMapper(mapperClass);
			result = executor.apply(mapper);
		}
		return result;
	}

	private static SqlSession openSession() {
		return factory.openSession(true);
	}

}

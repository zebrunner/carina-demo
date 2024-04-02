/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
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
 *******************************************************************************/
package com.zebrunner.carina.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.demo.api.DeleteUserMethod;
import com.zebrunner.carina.demo.api.GetUserMethods;
import com.zebrunner.carina.demo.api.PostUserMethod;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void getNumberOfCPUCores() {
        String command = "";
        //if(osValidator.isMac()){
        //command = "sysctl -n machdep.cpu.core_count";

        command = "lscpu";
        //if(osValidator.isWindows()){
        //    command = "cmd /C WMIC CPU Get /Format:List";
        
        Process process = null;
        int numberOfCores = 0;
        int sockets = 0;
        try {
            //if(osValidator.isMac()){
            String[] cmd = { "/bin/sh", "-c", command};
            process = Runtime.getRuntime().exec(cmd);
            // windows
            //process = Runtime.getRuntime().exec(command);

        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
                //if(osValidator.isMac()){
                // numberOfCores = line.length() > 0 ? Integer.parseInt(line) : 0;

                //Linux
                if (line.contains("Core(s) per socket:")) {
                    numberOfCores = Integer.parseInt(line.split("\\s+")[line.split("\\s+").length - 1]);
                }
                if(line.contains("Socket(s):")){
                    sockets = Integer.parseInt(line.split("\\s+")[line.split("\\s+").length - 1]);
                }
                //Windows
                //if (line.contains("NumberOfCores")) {
                //    numberOfCores = Integer.parseInt(line.split("=")[1]);
                //}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //if(osValidator.isUnix()){
        LOGGER.info("numberOfCores: ", numberOfCores);
        LOGGER.info("sockets: ", sockets);
        LOGGER.info("Total: ", numberOfCores * sockets);
        

        LOGGER.info("First, read the location where the corresponding resources are mounted");
        command = "cat /proc/mounts  | grep -E -w '(cpu|memory)'";
        try {
            String[] cmd = { "/bin/sh", "-c", command};
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        try {
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        LOGGER.info("For memory:");
        command = "cat /sys/fs/cgroup/memory/memory.limit_in_bytes";
        try {
            String[] cmd = { "/bin/sh", "-c", command};
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        try {
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        LOGGER.info("CPU resources:");
        LOGGER.info("the total time slice quota per CPU, in microseconds");
        command = "cat /sys/fs/cgroup/cpu,cpuacct/cpu.cfs_period_us";
        try {
            String[] cmd = { "/bin/sh", "-c", command};
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        try {
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        LOGGER.info("the CPU time that the container can occupy in the time slice");
        command = "cat /sys/fs/cgroup/cpu,cpuacct/cpu.cfs_quota_us";
        try {
            String[] cmd = { "/bin/sh", "-c", command};
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        try {
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        LOGGER.info("cpu.shares");
        command = "cat /sys/fs/cgroup/cpu,cpuacct/cpu.shares";
        try {
            String[] cmd = { "/bin/sh", "-c", command};
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        try {
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        LOGGER.info("export");
        command = "export";
        try {
            String[] cmd = { "/bin/sh", "-c", command};
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        try {
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        LOGGER.info("adb devices");
        command = "adb devices";
        try {
            String[] cmd = { "/bin/sh", "-c", command};
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        try {
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("/tmp/hyp-task-data.json"));
            for (String line2; (line2 = br.readLine()) != null;) {
                LOGGER.info(line2);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }        
        
        // Windows
        //LOGGER.info("numberOfCores: ", numberOfCores);
    }

    
/*    
    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUser() throws Exception {
        int cores = Runtime.getRuntime().availableProcessors();
        LOGGER.info("cpu cores: {}", cores);
        
        long maxMemory = Runtime.getRuntime().maxMemory();
        LOGGER.info("Max memory: {}", maxMemory);
        
        LOGGER.info("test");
        setCases("4555,54545");
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUserMissingSomeFields() throws Exception {
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");
        api.getProperties().remove("name");
        api.getProperties().remove("username");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetUsers() {
        GetUserMethods getUsersMethods = new GetUserMethods();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    public void testDeleteUsers() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.setProperties("api/users/user.properties");
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }
*/
    
}

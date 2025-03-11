package com.zebrunner.carina.demo.utils;

import java.util.List;

import com.zebrunner.agent.core.registrar.domain.TestRun;
import com.zebrunner.agent.core.registrar.domain.TestSession;
import com.zebrunner.agent.core.registrar.domain.TestStart;
import com.zebrunner.agent.core.registrar.maintainer.MaintainerProvider;

public class CustomMaintainerProvider2 implements MaintainerProvider {

    @Override
    public String provide(TestRun testRun, TestStart testStart, List<TestSession> list) {
        return "jackson";
    }

}

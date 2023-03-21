package com.qaprosoft.carina.demo.proxy;

import com.zebrunner.carina.proxy.IProxy;
import com.zebrunner.carina.proxy.IProxyRule;
import com.zebrunner.carina.utils.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

public class CustomProxyRule implements IProxyRule {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Optional<IProxy> getProxyInstance() {
        IProxy proxy = null;
        if (Configuration.getBoolean(Configuration.Parameter.BROWSERUP_PROXY)) {
            proxy = new CustomProxy();
        } else {
            LOGGER.debug("Proxy is disabled.");
        }
        return Optional.ofNullable(proxy);
    }
}

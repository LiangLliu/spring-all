package com.edwin.dubbo.server.provider;

import com.edwin.dubbo.common.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return null;
    }
}

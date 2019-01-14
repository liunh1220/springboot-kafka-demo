package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.service.ITestDubboService;
import org.springframework.stereotype.Component;

/**
 * Created by huyong on 2018/12/24.
 */
@Service(interfaceName = "testDubboService", interfaceClass = ITestDubboService.class,
        version ="${dubbo.provider.version}" ,timeout=1200000)
@Component
public class TestDubboServiceImpl implements ITestDubboService {
    @Override
    public void sysHello(String msg) {
        System.out.print("############### Dubbo #############");
    }
}

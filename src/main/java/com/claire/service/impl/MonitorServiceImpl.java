package com.claire.service.impl;

import com.claire.service.MonitorService;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;

/**
 * Created by hzn on 2018/1/7.
 */
@Service
public class MonitorServiceImpl implements MonitorService {
    @Override
    public int getFreeMemory(){
        OperatingSystemMXBean osmxb = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        long totalVirtualMemory = osmxb.getTotalPhysicalMemorySize();
        long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        Double compare = (freePhysicalMemorySize * 1.0 / totalVirtualMemory) * 100;
        return compare.intValue();
    }
}

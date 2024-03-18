package org.gulingjingguai.mzp.lesson.hsp;

import java.util.concurrent.atomic.AtomicLong;

public class SnowflakeIdWorker {
    private static final long EPOCH = 1577808000000L; // 自定义的时间起点，单位为毫秒，默认可以设置为2020-01-01T00:00:00Z的毫秒数
    private static final long SEQUENCE_BITS = 12; // 序列号位数
    private static final long WORKER_ID_BITS = 5; // 工作机器ID位数
    private static final long DATACENTER_ID_BITS = 5; // 数据中心ID位数

    private static final long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BITS);
    private static final long MAX_DATACENTER_ID = -1L ^ (-1L << DATACENTER_ID_BITS);
    private static final long SEQUENCE_MASK = -1L ^ (-1L << SEQUENCE_BITS);

    private final long workerId;
    private final long datacenterId;
    private final AtomicLong sequence = new AtomicLong(0L);
    private long lastTimestamp = -1L;

    public SnowflakeIdWorker(long workerId, long datacenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException("worker Id can't be greater than " + MAX_WORKER_ID + " or less than 0");
        }
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException("datacenter Id can't be greater than " + MAX_DATACENTER_ID + " or less than 0");
        }

        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format(
                    "Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence.incrementAndGet();
            if (sequence.get() > SEQUENCE_MASK) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence.set(0);
        }

        lastTimestamp = timestamp;

        return ((timestamp - EPOCH) << (WORKER_ID_BITS + DATACENTER_ID_BITS)) //
                | (datacenterId << WORKER_ID_BITS) //
                | (workerId << 0) //
                | (sequence.get());
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }
}
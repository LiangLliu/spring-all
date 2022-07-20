package com.lianglliu.springbootevents.springevents.utils;

public class IDGenerator {

    //开始该类生成ID的时间截，1288834974657 (Thu, 04 Nov 2010 01:42:54 GMT) 这一时刻到当前时间所经过的毫秒数，占 41 位（还有一位是符号位，永远为 0）。
    private final long startTime = 1463834116272L;

    //机器id所占的位数
    private long workerIdBits = 5L;

    //数据标识id所占的位数
    private long datacenterIdBits = 5L;

    //支持的最大机器id，结果是31,这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数（不信的话可以自己算一下，记住，计算机中存储一个数都是存储的补码，结果是负数要从补码得到原码）
    private long maxWorkerId = ~(-1L << workerIdBits);

    //支持的最大数据标识id
    private long maxDatacenterId = ~(-1L << datacenterIdBits);

    //序列在id中占的位数
    private long sequenceBits = 12L;

    //机器id向左移12位
    private long workerIdLeftShift = sequenceBits;

    //数据标识id向左移17位
    private long datacenterIdLeftShift = workerIdBits + workerIdLeftShift;

    //时间截向左移5+5+12=22位
    private long timestampLeftShift = datacenterIdBits + datacenterIdLeftShift;

    //生成序列的最大值(4095)，这里(-1L ^ (-1L << sequenceBits)) = 1111 1111 1111
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    //机房标识最大31
    private long datacenterId;

    //机器标识最大31
    private long workerId;

    //Id生成序列号 从0开始
    private volatile long sequence = 0L;

    //最后一次生成Id的时间戳
    private volatile long lastTimestamp;

    private IDGenerator(long workerId, long datacenterId) {
        if (workerId < 0 || workerId > maxWorkerId) {
            throw new IllegalArgumentException(
                    String.format("workerId[%d] is less than 0 or greater than maxWorkerId[%d].", workerId, maxWorkerId));
        }
        if (datacenterId < 0 || datacenterId > maxDatacenterId) {
            throw new IllegalArgumentException(
                    String.format("datacenterId[%d] is less than 0 or greater than maxDatacenterId[%d].", datacenterId, maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        //当前时间戳
        long timestamp = timeGen();

        //如果当前时间戳小于最后使用时间 则说明系统时钟变慢了
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  " +
                            "Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        //(4095+1) & (4095) = 0
        //如果序列号超过最大值则获取下一时刻时间戳
        sequence = (sequence + 1) & sequenceMask;
        if (sequence == 0) {
            timestamp = tilNextMillis(lastTimestamp);
        }

        //更新最后访问时间
        lastTimestamp = timestamp;

        //移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - startTime) << timestampLeftShift)
                | (datacenterId << datacenterIdLeftShift)
                | (workerId << workerIdLeftShift)
                | sequence;
    }

    /**
     * 获取下一时刻时间戳
     *
     * @param lastTimestamp 最后访问时间戳
     * @return 下一时刻时间戳
     */
    protected long tilNextMillis(final long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 获取系统时间
     *
     * @return 时间戳毫秒
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

    private IDGenerator() {
    }

    private static class SingletonInner {
        private static final IDGenerator instance = new IDGenerator(1, 1);
    }

    public static IDGenerator getInstance() {
        return SingletonInner.instance;
    }

    public static long getId() {
        return getInstance().nextId();
    }

}

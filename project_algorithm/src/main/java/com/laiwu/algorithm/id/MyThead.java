package com.laiwu.algorithm.id;

import java.util.Set;

class MyThread extends Thread {

    public Set<String> innerSet;

    public Set<String> sameSet;

    public int workId;

    public int dataCenterId;

    public MyThread(Set<String> set, int workId, int dataCenterId, Set<String> sameSet) {
        this.innerSet = set;
        this.workId = workId;
        this.dataCenterId = dataCenterId;
        this.sameSet = sameSet;
    }


    @Override
    public void run() {

        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(workId, dataCenterId);

        for (int i = 0; i < 10; i++) {
            long id = idWorker.nextId();
            String uniqueId = Long.toBinaryString(id);

            if (innerSet.contains(uniqueId)) {
                System.out.println("same happen" + uniqueId);
                sameSet.add(uniqueId);
            } else {
                innerSet.add(uniqueId);
            }


//            System.out.println(uniqueId);
//            System.out.println(id);
        }

        System.out.println(workId + " " + innerSet.size() + " "+ sameSet.size());

        System.out.println(innerSet);

    }
}
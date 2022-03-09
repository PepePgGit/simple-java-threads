package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resource
{
    private List<Integer> list = new ArrayList<>();
    private List<Integer> synchroList = Collections.synchronizedList(list);

    public synchronized int take() throws InterruptedException {

        while(synchroList.isEmpty()){
            wait();
        }

        int ret = synchroList.get(0);
        synchroList.remove(0);
        return ret;
    }

    public synchronized void put(Integer value){
        this.synchroList.add(value);
        notifyAll();
    }
}

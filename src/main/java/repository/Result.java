package repository;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
public class Result
{
    private List<Integer> list = new ArrayList<>();
    private List<Integer> synchroList = Collections.synchronizedList(list);
    
    public void putResult(int value)
    {
        synchroList.add(value);
    }

    @Override
    public String toString() {
        return "Result{" +
                "synchroList=" + synchroList +
                '}';
    }
}
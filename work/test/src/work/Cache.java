package work;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    private Map<String,String> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public String getValue(String key){
        //获取到读锁
        lock.readLock();
        return map.get(key);
    }

    public void setValue(String key, String value){
        lock.writeLock();
        map.put(key,value);
    }

}

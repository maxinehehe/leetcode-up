package june.code.byhehe.utils;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache2 {
    public static void main(String[] args) {

    }
}


class LRUCache1 extends LinkedHashMap<Integer, Integer>{
    //    LinkedHashMap<Integer, Integer> lru;
    public int capacity;
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > this.capacity;
    }

    public LRUCache1(int capacity) {
//         lru = new LinkedHashMap<>(capacity);
        super(capacity);
        this.capacity = capacity;

    }

    public int get(int key) {
        if(size()>=0)
            return this.get(key);
        else
            return -1;
    }

    public void put(int key, int value) {
        if(size() < capacity)
            this.put(key, value);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
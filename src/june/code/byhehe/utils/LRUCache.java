package june.code.byhehe.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * initialCapacity   初始容量
 *
 *  loadFactor    加载因子，一般是 0.75f
 *
 * accessOrder   false 基于插入顺序  true  基于访问顺序（get一个元素后，这个元素被加到最后，使用了LRU  最近最少被使用的调度算法）
 */
public class LRUCache extends LinkedHashMap {
    private int capacity;
    private static final long serialVersionUID = 1L;

    LRUCache(int capacity){
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        System.out.println(eldest.getKey() + " : "+eldest.getValue()+" will be removed!");
        return size() > capacity;
    }
}

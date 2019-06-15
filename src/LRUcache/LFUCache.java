package LRUcache;

import java.util.*;

public class LFUCache {
    int cap = -1;
    Map<Integer, Long> keyTime;
    Map<Integer, Integer> keyUse;
    Map<Integer, List<Integer>> useKey;
    Map<Integer, Integer> kv;

    public LFUCache(int capacity) {
        cap = capacity;
        keyTime = new HashMap<>();
        useKey = new HashMap<>();
        keyUse = new HashMap<>();
        kv = new HashMap<>();
    }

    public int get(int key) {
        if(keyUse.containsKey(key)){
            int useCount = keyUse.get(key);
            keyUse.put(key, useCount+1);
            keyTime.put(key, System.currentTimeMillis());

            useKey.get(useCount).remove(key);
            if(useKey.containsKey(useCount+1)){
                useKey.get(useCount+1).add(key);
            }else {
                List<Integer> tmp1 = new ArrayList<>();
                tmp1.add(key);
                useKey.put(useCount+1, tmp1);
            }
            return kv.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(!keyUse.containsKey(key)){
            if(keyUse.size() == cap){
                int min = Collections.min(useKey.keySet());
                List<Integer> minSet = useKey.get(min);
                int delKey = minSet.get(0);
                long delKeyTime = keyTime.get(delKey);
                for(int j=1; j<minSet.size(); j++){
                    if( keyTime.get(minSet.get(j)) < delKeyTime){
                        delKey = minSet.get(j);
                        delKeyTime = keyTime.get(minSet.get(j));
                    }
                }
                keyTime.remove(delKey);
                keyUse.remove(delKey);
                useKey.get(min).remove(delKey);
                if(useKey.get(min).size() == 0){
                    useKey.remove(min);
                }
                kv.remove(delKey);

            }else {
                cap++;
                kv.put(key, value);
                keyTime.put(key, System.currentTimeMillis());
                keyUse.put(key, 0);
                if(useKey.containsKey(0)){
                    useKey.get(0).add(key);
                }else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(key);
                    useKey.put(0, tmp);
                }
            }
        }
    }
}

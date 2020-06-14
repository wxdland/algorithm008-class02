package 第八周;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

  private Map<Integer,Integer> capedHashMap;

  public LRUCache(int capacity) {
    capedHashMap=new CapedHashMap(capacity);
  }

  public int get(int key) {
   if(!capedHashMap.containsKey(key)){
     return -1;
   }
   return capedHashMap.get(key);
  }

  public void put(int key, int value) {
    capedHashMap.put(key,value);
  }


 private class CapedHashMap<K,V> extends LinkedHashMap<K,V>{

    private int elementSize;

    public CapedHashMap(int elementSize) {
      super(16,0.75f,true);
      this.elementSize = elementSize;
    }

    @Override
   protected boolean removeEldestEntry(Map.Entry<K,V>eldest){
      return size()>elementSize;
   }
 }
}

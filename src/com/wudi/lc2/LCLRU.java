package com.wudi.lc2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LCLRU {
	
	
	public class LRUCache {
		private int timeStamp = 0;
	    private int capacity;
	    private PriorityQueue<Record> pq = new PriorityQueue<>();
	    private Map<Integer, Record> cache = new HashMap<>();
	    
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        // Get from cache directly
	        if (cache.containsKey(key)) {
	            // update key timeUsed
	            Record record = cache.get(key);
	            pq.remove(record);
	            record.timeUsed ++;
	            record.timeStamp = timeStamp ++;
	            pq.add(record);
	            // return result
	            return record.value;
	        }
	        else {
	            return -1;
	        }
	    }
	    
	    public void set(int key, int value) {
	        // if the key already exists
	        // remove it
	        if (cache.containsKey(key)) {
	            Record record = cache.get(key);
	            cache.remove(key);
	            pq.remove(record);
	        }
	        
	        // if capacity is reached
	        // remove least used one
	        if (cache.size() == this.capacity) {
	            Record record = pq.poll();
	            cache.remove(record.key);
	        }
	        
	        // insert a new record
	        Record record = new Record(key, value);
	        record.timeStamp = timeStamp ++;
	        cache.put(key, record);
	        pq.add(record);
	    }
	    
	    class Record implements Comparable<Record> {
	        public int key;
	        public int value;
	        public int timeUsed;
	        private int timeStamp;
	        
	        public Record(int key, int value) {
	            this.key = key;
	            this.value = value;
	            this.timeUsed = 1;
	        }
	        
	        public int compareTo(Record rhs) {
	            if (timeUsed < rhs.timeUsed)
	            	return -1;
	            else if (timeUsed > rhs.timeUsed) 
	            	return 1;
	            else {
	            	if (timeStamp > rhs.timeStamp) return 1;
	            	else if (timeStamp < rhs.timeStamp) return -1;
	            }
	            return 0;
	        }
	    }
	}
}

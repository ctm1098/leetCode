package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    /*
    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:

    - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    - int get(int key) Return the value of the key if the key exists, otherwise return -1.
    - void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
                                   If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    The functions get and put must each run in O(1) average time complexity.
    */

    //Key to value map
    private Map<Integer,Integer> keyToIndexMap;
    

    public LRUCache(int capacity) {
        keyToIndexMap = new LinkedHashMap<Integer, Integer>(capacity, 2, true) {
            @Override 
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (!keyToIndexMap.containsKey(key))
            return -1;
        return keyToIndexMap.get(key);
    }
    
    public void put(int key, int value) {
        keyToIndexMap.put(key,value);
    }

    public void print() {
        for (Map.Entry<Integer,Integer> entry : keyToIndexMap.entrySet()) {
            System.out.println("["+entry.getKey()+", "+entry.getValue()+"]");
        }
    }
}

/* Other versions

class LRUCache { //V1 (my own double linked structure)

    //A node that contains the index in cache for a value and its corresponding key
    //These nodes conform a list which will be sorted by "LRU values" (this is, from least recently used to most)
    private static class DLNode {
        DLNode prev,next;
        int key,index;
        
        public DLNode(int index, int key, DLNode prev) {
            this.index = index;
            this.key = key;
            this.prev = prev;
            //next = null;
        }

    }
    
    private int cap;
    private int values[];
    //This map will allow us to associate a key with its corresponding node, while nodes will be used to manage the priority for the LRU politics
    private Map<Integer,DLNode> lruValuesMap;
    private DLNode firstNode, lastNode;
    

    public LRUCache(int capacity) {
        cap = capacity;
        values = new int[cap];
        lruValuesMap = new HashMap<>();
    }
    
    private void updateLRUValue(int key) {
        
            EXAMPLE -> we have the following keys in the DL list, going from least recently used to most recently: 1 <--> 2 <--> 3
            Key 2 has just been referred, so the list must result into 1 <--> 3 <--> 2
            The main idea is to locate the key-referring node N, then make a connection between both previous and next nodes and move N to the end of the list
        

        //This is the most recently used node, we get it by the key which has just been referenced
        DLNode node = lruValuesMap.get(key);
        if (node == firstNode) {
            //If it is the first node (AKA the least recently used one), then the first node will now be the next one (the second recently used one)
            //If this turns also to be the last node, a problem arises as its successor is null, so the new first node cannot be null but again the same one, meaning there's only one node
            firstNode = (node.next == null ? node : node.next);
            //First node has no predecessors
            firstNode.prev = null;
        }
        else {
            //If it's any other node, we procure to connect both previous and next nodes (it may be the last node in the list, so it has no successors)
            node.prev.next = (node.next == null ? node : node.next);
            if (node.next != null) node.next.prev = node.prev;
        }
        //The old (currently) tail of the list must lead to the new tail
        //Again, we must be carefull in case the new tail were already the tail, otherwise we'd end up having this node referring to itself
        if (node != lastNode) {
            lastNode.next = node;
            node.prev = lastNode;
        }
        //Since the list goes from least recently used values to most recently used,
        lastNode = node;
        lastNode.next = null;
    }

    public int get(int key) {
        if (!lruValuesMap.containsKey(key))
            return -1;
        updateLRUValue(key);
        //With a known key, we can gain access to its node through the map, and from there get the index in which the value is stored in cache
        return values[lruValuesMap.get(key).index];
    }
    
    public void put(int key, int value) {
        if (lruValuesMap.containsKey(key)) {
            values[lruValuesMap.get(key).index] = value;
            updateLRUValue(key);
        }
        else {
            DLNode node;
            int index;
            boolean limit = false;
            
            if (lruValuesMap.size() + 1 > cap) {
                index = firstNode.index;
                lruValuesMap.remove(firstNode.key);
                limit = true;
            }

            else index = lruValuesMap.size();

            node = new DLNode(index,key,lastNode);
            lruValuesMap.put(key, node);
            values[index] = value;

            if (firstNode == null) firstNode = node;
            if (limit) {
                firstNode = (firstNode.next == null ? node : firstNode.next);
                firstNode.prev = null;
            }

            if (lastNode != null) lastNode.next = node;
            lastNode = node;
            
        }
    }
}


class LRUCache { //V2 (LinkedHashMap used, but without access order)
    private int values[];
    private final int MAX;
    //Key to index map
    private Map<Integer,Integer> keyToIndexMap;
    

    public LRUCache(int capacity) {
        MAX = capacity;
        values = new int[MAX];
        keyToIndexMap = new LinkedHashMap<>() {
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > MAX;
            }
        };
    }

    private void updateLRUValues(int key) {
        int idx = keyToIndexMap.get(key);
        keyToIndexMap.remove(key);
        keyToIndexMap.put(key, idx);
    }

    public int get(int key) {
        if (!keyToIndexMap.containsKey(key))
            return -1;
        updateLRUValues(key);
        return values[keyToIndexMap.get(key)];
    }
    
    public void put(int key, int value) {
        int idx;
        if (keyToIndexMap.containsKey(key)) {
            idx = keyToIndexMap.get(key);
            updateLRUValues(key);
        }
        else {
            idx = keyToIndexMap.size();
            //If MAX is reached, we obtain the index of the first entry in the map (it's the eldest one)
            if (idx == MAX) idx = keyToIndexMap.entrySet().iterator().next().getValue();
            keyToIndexMap.put(key,idx);
        }
        values[idx] = value;
    }
}





*/
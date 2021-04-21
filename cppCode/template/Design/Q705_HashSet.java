package leetcode.template.Design;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/29 15:36
 */
public class Q705_HashSet {

    class MyHashSet {
        private Bucket[] bucketArray;
        private int keyRange;

        /** Initialize your data structure here. */
        public MyHashSet() {
            this.keyRange = 769;
            this.bucketArray = new Bucket[this.keyRange];
            for (int i = 0; i < this.keyRange; ++i) {
                this.bucketArray[i] = new Bucket();
            }
        }

        protected int _hash(int key) {
            return (key % this.keyRange);
        }

        public void add(int key) {
            int bucketIndex = this._hash(key);
            this.bucketArray[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = this._hash(key);
            this.bucketArray[bucketIndex].delete(key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int bucketIndex = this._hash(key);
            return this.bucketArray[bucketIndex].exists(key);
        }
    }


    class Bucket {
        private LinkedList<Integer> container;

        public Bucket() {
            container = new LinkedList<>();
        }

        public void insert(int key) {
            int index = this.container.indexOf(key);
            if (index == -1) {
                this.container.addFirst(key);
            }
        }

        public void delete(Integer key) {
            this.container.remove(key);
        }

        public boolean exists(int key) {
            int index = this.container.indexOf(key);
            return (index != -1);
        }
    }

}

class MyHashSet {

    /** Initialize your data structure here. */

    int cap = 769;
    Bucket[] buckets;
    public MyHashSet() {
        buckets = new Bucket[cap];
        for(int i = 0; i < cap; i++) {
            buckets[i] = new Bucket();
        }
    }
    int _hash(int key) {
        return key % cap;
    }
    public void add(int key) {
        int idx = _hash(key);
        buckets[idx].insert(key);
    }

    public void remove(int key) {
        int idx = _hash(key);
        buckets[idx].delete(key);
    }


    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = _hash(key);
        return buckets[idx].contains(key);
    }
    class Bucket {
        private LinkedList<Integer> list;
        public Bucket(){
            list = new LinkedList<>();
        }
        public void insert(Integer key) {
            if(list.indexOf(key) == -1) {
                list.addFirst(key);
            }
        }
        public void delete(Integer key) {
            list.remove(key);
        }
        public boolean contains(Integer key) {
            return list.indexOf(key) != -1;
        }
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

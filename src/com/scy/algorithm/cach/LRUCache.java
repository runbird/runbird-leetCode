package com.scy.algorithm.cach;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * 类名： LRUCache <br>
 * 描述：TODO <br>
 * 创建日期： 2021/8/13 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class LRUCache<K, V> implements Iterable<K> {

    static int THRESHOLD = 3;

    private LinkedHashMap<K, V> cache = new LinkedHashMap();

    private void cache(K k, V v) {
        if (cache.containsKey(k)) {
            cache.remove(k);
            // 错误写法  cache.remove(k,v);
        } else if (cache.size() >= THRESHOLD) {
            var it = cache.keySet().iterator();
            var first = it.next();
            cache.remove(first);
        }
        cache.put(k, v);
    }

    @Override
    public Iterator<K> iterator() {
        var it = cache.entrySet().iterator();
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public K next() {
                return it.next().getKey();
            }
        };
    }

    public static void main(String[] args) {
        var cache = new LRUCache<String, Integer>();
        cache.cache("A", 1);
        cache.cache("B", 2);
        cache.cache("C", 3);

        cache.cache("D", 4);
        cache.cache("C", 9);
        System.out.println(
                "leave <-" + StreamSupport.stream(cache.spliterator(), false)
                        .map(String::toString)
                        .collect(Collectors.joining("<-")));
    }

}

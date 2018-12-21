package com.superman.face;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 作者 Superman
 * 日期 2018/12/20 15:45.
 * 文件 FaceStudy
 * 描述 TreeMap示例 遍历TreeMap的测试程序。
 */

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        int val;
        Random r = new Random();//用于获取随机数
        for (int i = 0; i < 10; i++) {
            val = r.nextInt(100);  // 随机获取一个[0,100)之间的数字
            String key = val+"";
            Integer value = r.nextInt(10);
            treeMap.put(key,value);
        }
        System.out.println(treeMap);

        /*****************测试treemap的api方法****************/
        testTreeMapApis(treeMap);
        /*******测试TreeMap的子Map函数*******/
        testSubMapApis();
        /*******测试TreeMap的导航函数*******/
        testNavigableMapApis();

        /***************通过entrySet()遍历TreeMap的key-value********************/
        iteratorTreeMapByEntryset(treeMap);
        /***************通过keySet()遍历TreeMap的key-value,不如entrySet效率高********************/
        iteratorTreeMapByKeyset(treeMap) ;
        /***************通过values()遍历TreeMap的value********************/
        iteratorTreeMapByValues(treeMap) ;
    }

    private static void testNavigableMapApis() {
        NavigableMap<String,Integer>nav = new TreeMap<>();
        // 添加“键值对”
        nav.put("aaa", 111);
        nav.put("bbb", 222);
        nav.put("eee", 333);
        nav.put("ccc", 555);
        nav.put("ddd", 444);
        System.out.println(nav);
        System.out.printf("First key: %s\tFirst entry: %s%n",nav.firstKey(), nav.firstEntry());
        System.out.printf("First key: %s\tFirst entry: %s%n",nav.lastKey(), nav.lastEntry());
        // 获取“小于/等于bbb”的最大键值对
       System.out.printf("Key floor before bbb: %s%n",nav.floorKey("bbb"));
        // 获取“小于”的最大键值对
        System.out.printf("Key floor before bbb: %s%n",nav.lowerKey("bbb"));
        //获取“大于/等于bbb”的最小键值对
        System.out.printf("Key ceiling after ccc: %s%n",nav.ceilingKey("bbb"));
        //获取“大于bbb”的最小键值对
        System.out.printf("Key ceiling after ccc: %s%n",nav.higherKey("bbb"));
    }

    private static void testTreeMapApis(TreeMap treeMap) {
        if (treeMap == null) {
            return;
        }
        System.out.println("size is "+treeMap.size());
        System.out.println("contains 10 is "+treeMap.containsKey("10"));//containsValue
        // remove(Object key) ： 删除键key对应的键值对
//       treeMap.remove("1");
        treeMap.clear();//清空
        // isEmpty() : TreeMap是否为空
      System.out.println( (treeMap.isEmpty()?"tmap is empty":"treeMap is not empty") );

    }

    private static void testSubMapApis() {
        // 新建TreeMap
        TreeMap tmap = new TreeMap();
        // 添加“键值对”
        tmap.put("a", 101);
        tmap.put("b", 102);
        tmap.put("c", 103);
        tmap.put("d", 104);
        tmap.put("e", 105);
        SortedMap<String,Integer> sortedMap=tmap.headMap("e");//返回小于"e"的视图。不包括"e"
        System.out.println(sortedMap);
       SortedMap<String,Integer> sortedMap2= tmap.tailMap("b",false);//默认返回大于等于"b"的视图,true表示包含b，false表示不包含。
        System.out.println(sortedMap2);
        SortedMap<String,Integer>sortedMap3= tmap.subMap("b","e");//返回大于"b"小于"e"的视图,左闭右开
        System.out.println(sortedMap3);
    }

    private static void iteratorTreeMapByEntryset(TreeMap treeMap) {
        if(treeMap==null)return;
        Iterator iterator = treeMap.entrySet().iterator();//拿到key-value的迭代器。
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key is "+entry.getKey()+";value is "+entry.getValue());
        }
    }

    private static void iteratorTreeMapByKeyset(TreeMap treeMap) {
        if (treeMap == null) {
            return;
        }
        Iterator iterator = treeMap.keySet().iterator();
        while (iterator.hasNext()){
          String key = (String) iterator.next();
            System.out.println("key is "+key+";value is "+treeMap.get(key));
        }
    }

    private static void iteratorTreeMapByValues(TreeMap treeMap) {
        if (treeMap == null) {
            return;
        }
        Iterator iterator =  treeMap.values().iterator();
        while (iterator.hasNext()){
            Integer value = (Integer) iterator.next();
            System.out.println("value is "+value);
        }
    }

}

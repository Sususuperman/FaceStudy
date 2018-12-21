package com.superman.face;

import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * 作者 Superman
 * 日期 2018/12/20 10:17.
 * 文件 FaceStudy
 * 描述 HashMap示例
 */

public class HashMapTest {
    private static final String TAG = "HashMapTest";

    public static void main(String[] args) {
        testHashMapApis();
    }

    private static void testHashMapApis() {
        //打印输出hashmap
        Random random = new Random();
        HashMap hashMap = new HashMap();
        hashMap.put("one", random.nextInt(10));
        hashMap.put("two", random.nextInt(10));
        hashMap.put("three", random.nextInt(10));
        System.out.print(hashMap);

        //使用Iterator遍历key-value
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.print("next : " + entry.getKey() + "-" + entry.getValue() + " ");
        }

        //键值对个数
        System.out.print("" + hashMap.size());

        //containsKey/Value
        System.out.println("contains one : " + hashMap.containsKey("one"));
        System.out.println("contains 3 : " + hashMap.containsValue(3));


        //移除key对应的键值对
        hashMap.remove("one");
        System.out.println("map: "+hashMap);

        //是否为空
        System.out.println(hashMap.isEmpty()?"map is empty ":"map is not empty ");

    }


}

package com.scy.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： FizzBuzz <br>
 * 描述：TODO <br>
 * 创建日期： 2020/7/4 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            }else if(i % 3 == 0){
                result.add("Fizz");
            }else if(i % 5 == 0){
                result.add("Buzz");
            }else{
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FizzBuzz temp = new FizzBuzz();
        List<String> list = temp.fizzBuzz(15);
        list.forEach(System.out::println);
    }
}

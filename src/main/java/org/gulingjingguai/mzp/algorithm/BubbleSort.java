package org.gulingjingguai.mzp.algorithm;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/**
 * 冒泡排序：
 * 思想：
 * 1.每次遍历寻找出一个可以确认位置的元素
 */
public class BubbleSort {
    public static void main(String[] args) {
        Vector vector = new Vector();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String in = scanner.next();
            if("end".equals(in)){
                break;
            }else{
                vector.add(in);
            }
        }
        bubbleSort(vector);
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }
    }

    private static void bubbleSort(Vector vector) {
        for (int i = 0; i < vector.size() - 1; i++) {
            for (int j = 0; j < vector.size() - i - 1; j++) {
                if (Integer.parseInt(vector.get(j).toString()) > Integer.parseInt(vector.get(j + 1).toString())) {
                    String temp = vector.get(j).toString();
                    vector.set(j, vector.get(j + 1));
                    vector.set(j + 1, temp);
                }
            }
        }
    }
}

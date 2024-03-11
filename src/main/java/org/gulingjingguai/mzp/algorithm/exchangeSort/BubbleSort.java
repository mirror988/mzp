package org.gulingjingguai.mzp.algorithm.exchangeSort;

import java.util.Scanner;
import java.util.Vector;

/**
 * 冒泡排序：
 * 思想：
 * 1.每次遍历将一个元素放到最终确认的位置
 * 2.去除1步骤的元素，再次进行遍历，直到结束
 */
public class BubbleSort {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            Integer in = scanner.nextInt();
            if("-1".equals(in.toString())){
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

    /**
     * 冒泡排序算法
     * @param vector
     */
    private static void bubbleSort(Vector<Integer> vector) {
        for (int j = 0;j < vector.size() - 1;j++){
            for (int i = 0; i < vector.size() - j - 1; i++) {
                if(vector.get(i) > vector.get(i + 1)){
                    int temp = vector.get(i + 1);
                    vector.set(i + 1, vector.get(i));
                    vector.set(i, temp);
                }
            }
        }
    }
}

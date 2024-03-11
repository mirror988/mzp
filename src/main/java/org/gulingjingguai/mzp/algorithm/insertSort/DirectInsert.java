package org.gulingjingguai.mzp.algorithm.insertSort;

import java.util.Scanner;
import java.util.Vector;

/**
 * 直接插入排序：
 * 思想：
 * 1.将需要排序的列表分为两部分，一部分为已经排好的区间（列表的第一个元素），另一部分为需要排序的区间（剩余的所有元素）
 * 2.从第二个元素开始，将第二个元素放入到排好的区间。并使排好的区间依然有序
 * 3.重复2步骤，直到所有的元素都在已排好的区间
 */
public class DirectInsert {
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
//        directInsert(vector);
        directInsertOptimize(vector);
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }
    }

    /**
     * 直接插入排序优化实现
     * 优化：
     * 前面做的是拿需要插入的元素，从已经排好的区间从头开始比较。
     * 但是需要插入的元素离尾部元素比较近。而且尾部元素就已经是排好序的区间的最大值。
     * 我们只需要从已排好的区间的尾部开始比较，直到比较到比插入元素小的位置。
     * 并且可以一边比较一边移动
     * @param vector
     */
    private static void directInsertOptimize(Vector<Integer> vector) {
        //从第二个元素开始
        for (int i = 1; i < vector.size(); i++) {
            int insertElement = vector.get(i);
            int j = i;
            while(j > 0 && insertElement < vector.get(j - 1)){
                vector.set(j,vector.get(j - 1));
                j--;
            }
            vector.set(j,insertElement);
        }
    }

    /**
     * 直接插入排序算法
     * @param vector
     */
    private static void directInsert(Vector<Integer> vector) {
        //记录第一个元素的信息
        int j = 1;
        int firstElement = vector.get(0);
        //循环向有序区间插入元素
        for (int i = 1; i <= vector.size() - 1; i++) {
            int insertElement = vector.get(i);
            int p = 0;
            while(p < j){
                if(vector.get(p) > insertElement){
                    //找到了需要插入的位置，比插入元素大的元素全部向后移动
                    int q = i;
                    while(q != p){
                        vector.set(q,vector.get(q - 1));
                        q--;
                    }
                    vector.set(p,insertElement);
                    j++;
                    break;
                }else{
                    p++;
                    //如果已经扎到最后了，那说明这个元素是最大的，直接把有序区间扩大一位即可
                    if(p == j){
                        j++;
                        break;
                    }
                }
            }
        }
    }
}
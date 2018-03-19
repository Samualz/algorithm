package com.samual;

import com.samual.sort.Sort;
import com.samual.sort.impl.ISelectSort;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] arr = SortUtils.generateRandomArray(10000, 1001);

        ISelectSort sort = (ISelectSort)new ExecuteTimeProxy().bind(new Sort());
        /*//插入排序
        sort.insertSort(arr);
        SortUtils.sortPrint(arr);
        //选择排序
        sort.selectSort(arr);
        SortUtils.sortPrint(arr);
        //优化插入排序
        sort.optimizeInsertSort(arr);
        SortUtils.sortPrint(arr);
        //冒泡排序
        sort.bubbleSort(arr);
        SortUtils.sortPrint(arr);
        //高级冒泡排序
        sort.optimizeBubbleSort(arr);
        SortUtils.sortPrint(arr);
        //希尔排序
        sort.shellSort(arr);
        SortUtils.sortPrint(arr);
        //归并排序
        sort.mergeSort(arr);
        SortUtils.sortPrint(arr);
        //自底向上归并排序
        sort.mergeSortBU(arr);
        SortUtils.sortPrint(arr);*/
        //快速排序
        /*sort.quickSort(arr);
        SortUtils.sortPrint(arr);*/
        //双路快排
        System.out.println(sort);
        sort.quickSort2(arr);
        SortUtils.sortPrint(arr);
    }
}

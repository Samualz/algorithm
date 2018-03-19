package com.samual.sort;

import com.samual.SortUtils;
import com.samual.sort.impl.ISelectSort;

import java.util.ArrayList;


/*
 * 创建排序算法
* */
public class Sort implements ISelectSort{

   /* public static void main(String[] args) {

        int[] arr = SortUtils.generateRandomArray(100,10);
        SortUtils.sortPrint(arr);
        new ExecuteTimeProxy().bind();
        selectSort(arr);
        SortUtils.sortPrint(arr);
    }*/


    /**
      * author:sam
      * date:2018/1/26 14:11
      * describe:选择排序
      */
    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length && arr[minIndex] > arr[j]; j++) {
                    minIndex = j;
            }
            SortUtils.swap(arr,minIndex,i);
        }
    }

    /**
      * author:sam
      * date:2018/3/7 10:49
      * describe:插入排序
      */
    @Override
    public void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                SortUtils.swap(arr,j,j-1);
            }
        }
    }

    /**
      * author:sam
      * date:2018/3/7 12:21
      * describe:插入排序优化
      */
    @Override
    public void optimizeInsertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];
            int index = i;
            for (int j = i; j > 0 && arr[j-1] > e; j--) {
                arr[j] = arr[j - 1];
                index = j - 1;
            }
            arr[index] = e;
        }
    }
    /**
      * author:sam
      * date:2018/3/8 18:43
      * describe:插入排序（数组部分内容）
      */
    public void insertionSort(int[] arr,int l,int r){

        for (int i = l + 1; i <= r; i++) {
            int tmp = arr[i];
            int index = i;
            for (int j = i - 1; j >= l && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
                index = j;
            }
            arr[index] = tmp;
        }
    }

    /**
      * author:sam
      * date:2018/3/7 14:37
      * describe:冒泡排序
      */
    public void bubbleSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if(arr[j] > arr[j+1]){
                    SortUtils.swap(arr,j,j+1);
                }
            }
        }
    }
    /**
      * author:sam
      * date:2018/3/7 14:49
      * describe:优化冒泡排序
      */
    @Override
    public void optimizeBubbleSort(int[] arr){
       boolean flag;
       int n = arr.length;
       do{
           flag = false;
           for (int i = 0; i < n - 1; i++) {
                if(arr[i] > arr[i + 1]){
                    SortUtils.swap(arr,i,i + 1);
                    flag = true;
                }
           }
           n--;
       }while(flag);
    }

    /**
      * author:sam
      * date:2018/3/8 14:09
      * describe:希尔排序
      */
    public void shellSort(int[] arr){
        int n = 1;
        int len = arr.length;
        //确定序列
        while(n < len/3){
            n = 3*n + 1;
        }
        while(n>0){
            for (int i = n; i < len; i += n) {
                int tmp = arr[i];
                int index = i;
                for (int j = i; i-n > 0 && arr[i-n] > arr[i]; j -= n) {
                    arr[i] = arr[i-n];
                    index = i - n;
                }
                arr[index] = tmp;
            }
            n /= 3;
        }
    }
    /**
      * author:sam
      * date:2018/3/8 16:27
      * describe:归并排序算法
      */
    public void mergeSort(int[] arr){
        __mergeSort(arr,0,arr.length-1);
    }
    /**
      * author:sam
      * date:2018/3/8 16:15
      * describe:归并排序递归函数，arr[l,r]
      */
    private void __mergeSort(int[] arr,int l,int r){
        /*if(l >= r)
            return;*/
        if(r - l <= 15){
            insertionSort(arr,l,r);
            return;
        }

        int mid = (l + r)/2;
        __mergeSort(arr,l,mid);
        __mergeSort(arr,mid + 1,r);
        if(arr[mid] > arr[mid + 1])//归并排序优化
            __merge(arr,l,mid,r);
    }
    /**
      * author:sam
      * date:2018/3/8 16:44
      * describe:合并算法
      */
    private void __merge(int[] arr,int l,int mid,int r){
        //复制数组
        int[] aux = new int[r-l+1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        //定义索引
        int i = l,j = mid + 1;
        for (int k = l; k <= r; k++) {
            if(i > mid){
                arr[k] = aux[j - l];
                j++;
            }else if(j > r){
                arr[k] = aux[i - l];
                i++;
            }else if(aux[i - l] > aux[j - l]){
                arr[k] = aux[j - l];
                j++;
            }else{
                arr[k] = aux[i - l];
                i++;
            }
        }
    }

    /**
      * author:sam
      * date:2018/3/8 19:17
      * describe:自底向上的归并排序
      * 没有使用
      */
    public void mergeSortBU(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len/2; i += i) {
            for (int j = 0; j + i < len; j += 2*i) {
                if(j + 2*i -1 > len - 1){
                    __merge(arr,j ,j + i - 1,len -1);
                }else{
                    __merge(arr,j,i + j - 1,j + 2*i -1);
                }
            }
        }
    }
    /**
     * author:sam
     * date:2018/3/8 14:10
     * describe:快速排序
     */
    public void quickSort(int[] arr){
        __quickSort(arr,0,arr.length - 1);
    }
    private void __quickSort(int[] arr,int l,int r){
        if(r - l <= 15){//优化
            insertionSort(arr,l,r);
            return;
        }
        int p = __partition(arr,l,r);
        __quickSort(arr,l,p - 1);
        __quickSort(arr,p + 1,r);
    }
    /**
      * author:sam
      * date:2018/3/9 16:22
      * describe:普通分隔算法
      */
    //arr[l...r]
    private int __partition(int[] arr, int l, int r) {
        int random = SortUtils.generateRandom(l, r);
        //在近乎有序数组的情况下，快速排序交换比较频繁，利用生成随机数来确定中间的数据为原点数据
        SortUtils.swap(arr,l,random);//与初始位置进行数据交换
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(arr[i] < v)
                SortUtils.swap(arr,++j,i);
        }
        SortUtils.swap(arr,l,j);
        return j;
    }

    /**
      * author:sam
      * date:2018/3/9 17:08
      * describe:双路快排
      */
    public void quickSort2(int[] arr){
        __quickSort2(arr,0,arr.length-1);
    }
    /**
      * author:sam
      * date:2018/3/9 17:03
      * describe:双路快排
      */
    public void __quickSort2(int[] arr,int l,int r){
        if(r - l >= 15) {
            insertionSort(arr, l, r);
            return;
        }
        int p = __partitionDouble(arr, l, r);
        __partitionDouble(arr,l,p - 1);
        __partitionDouble(arr,p + 1,r);
    }
    /**
      * author:sam
      * date:2018/3/9 16:23
      * describe:双路分割算法
      */
    private int __partitionDouble(int[] arr,int l,int r){
        int random = SortUtils.generateRandom(l, r);
        SortUtils.swap(arr,l,random);
        /*int v = arr[l];
        int j = l,k = r;
        for (int m = l + 1,n = r;m <= n && j <= k; m++ ,n--) {
            if(arr[m] <= v)
                SortUtils.swap(arr,++j,m);
            if(arr[n] >= v)
                SortUtils.swap(arr,--k,n);
        }
        SortUtils.swap(arr,l,j);*/
        int v = arr[l];
        int i = l + 1,j = r;
        while(true){
            while (arr[i] <= v) i++;
            while (arr[j] >= v) j--;
            if(i > j) break;
            SortUtils.swap(arr,i,j);
            i++;j--;
        }
        SortUtils.swap(arr,l,i);
        return i ;
    }
}
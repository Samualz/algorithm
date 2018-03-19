package com.samual;

import java.util.Random;

/**
 * author:sam
 * date:2018/1/26
 * describe:工具类
 */
public class SortUtils {
    /**
      * author:sam
      * date:2018/1/26 14:25
      * describe:交换元素
      */
    public static void swap(int[] arr,int pre,int last){
        int temp = arr[pre];
        arr[pre] = arr[last];
        arr[last] = temp;
    }
    /**
      * author:sam
      * date:2018/1/26 14:25
      * describe:打印方法
      */
    public static void sortPrint(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (i == 0){
                System.out.print("[" + arr[0] + ",");
            }else if(i == arr.length - 1){
                System.out.println(arr[i] + "]");
            }else{
                System.out.print(arr[i]+",");
            }
        }
    }

    /**
      * author:sam
      * date:2018/3/6 14:56
      * describe:生成随机数方法
      */
    public static int[] generateRandomArray(int m, int n){
        if(m<=0) return null;
        if(n<=0) return null;
        if(m< n) return null;

        int[] intRet = new int[n];
        int intRd = 0; // 存放随机数
        int count = 0; // 记录生成的随机数个数
        boolean flag = false;  // 是否已经生成过标志
        while(count< n){
            Random rdm = new Random(System.currentTimeMillis());
            intRd = Math.abs(rdm.nextInt())%m +1;
            for(int i=0;i<count;i++){
                if(intRet[i]==intRd){
                    flag = true;
                    break;
                }else{
                    flag = false;
                }
            }
            if(flag==false){
                intRet[count] = intRd;
                count++;
            }
        }
        return intRet;
    }
    
    public static int generateRandom(int l,int r){
        Random random = new Random();
        return random.nextInt(r - l + 1) + l;
    }
}

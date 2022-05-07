package com.example.demo.decorete;

import cn.hutool.json.JSONObject;
import org.springframework.util.DigestUtils;

import java.util.Arrays;

/**
 * @author: liusj
 * @date: 2021/11/11
 */
public class MainDemo {

    public static void main(String[] args) {
        Decorate decorate = new BaseDecorate();
        KitchenDecorate kitchenDecorate = new KitchenDecorate(decorate);

        kitchenDecorate.decorate();

        String md5DigestAsHex = DigestUtils.md5DigestAsHex(("admin@ZHFH!").getBytes());
        String newString = StringTools.convert(md5DigestAsHex);
        System.out.println(newString);
        String pwdEncrypt = Md5Utils.generatePwdEncrypt(newString, "40d34d6a1d19420883f3888dabe718df");
        System.out.println(pwdEncrypt);

        int[] nums = {3, 6, 4, 5, 1, 2};
        bubbleSort(nums);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));

        JSONObject requestJson = new JSONObject();
        // 二级商户号
        requestJson.put("subMchId", "1601985045");
        // 微信订单号
        requestJson.put("transactionId", "4200001299202112078054063073");
        // 业务系统订单号
        requestJson.put("outOrderNo", "202112071620530753501");
        // 系统来源
        requestJson.put("systemSource", 4);
        System.out.println(requestJson.toString());
        System.out.println(5 / 2);

        String adc = "Hello World";
        add(adc);
        System.out.println(adc);

        String abc = "192.168.2.225";
        char[] chars = abc.toCharArray();
        System.out.println(chars.length);
    }

    public static void add(String abc) {
        abc = "123456";
        abc = abc + "123456";
        System.out.println(abc);
    }

    /**
     * 插入排序.
     * <p>
     * 1。内循环从1开始，往前循环
     * 2. 内循环不交换位置，如果有序，内循环可以提交结束。
     * 3. 内循环每次循环次数+1(最坏情况)
     */
    public static void insertSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) return;

        for (int i = 1; i < length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
    }

    /**
     * 冒泡排序: 两两比较，大的往后放。
     * <p>
     * 1. 内循环从0开始
     * 2. 内循环每次循环次数-1
     * 3. 内循环如果不交换位置，如说明已经有序，可以退出。
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        int length = nums.length;
        if (length <= 0) return;

        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }
}

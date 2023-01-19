package Lianxi;

import java.util.Random;
import java.util.Scanner;

//双色球系统模拟实验
public class Demo03 {
    public static void main(String[] args) {
        //生成中奖号码
        int[] arr = createNumber();
        System.out.println("==============================================");
        for (int i = 0; i < 6; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println("=====================================================");
        //用户输入彩票号码
        int[] userInputArr = userInputNumber();
//        for (int i = 0; i < userInputArr.length; i++) {
//            System.out.print(userInputArr[i] + " ");
//        }

        //判断中奖情况
        int redCount = 0;
        int blueCount = 0;
        //判断红球
        for (int i = 0; i < userInputArr.length - 1; i++) {
            int redNumber = userInputArr[i];
            for (int j = 0; j < arr.length - 1; j++) {
                if (redNumber == arr[j]) {
                    redCount++;
                    break;
                }
            }
        }
        //判断篮球
        int blueNumber = userInputArr[userInputArr.length - 1];
        if (blueNumber == arr[arr.length - 1]) {
            blueCount++;
        }
        System.out.println("红球中了" + redCount + "个");
        System.out.println("篮球中了" + blueCount + "个");

    }

    //生成中奖号码
    public static int[] createNumber() {
        //创建数组用于存放中奖号码
        //6红1蓝 数组长度；7
        int[] arr = new int[7];
        //生成随机数添加到数组中
        //红球6个不可重复 篮球一个可重复
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            //获取红球号码
            int redNumber = r.nextInt(33) + 1;
            boolean flag = contains(arr, redNumber);
            if (!flag) {
                //把红球号码添加到数组中
                arr[i] = redNumber;
                i++;
            }
        }
        //生成蓝球号码添加到数组
        int blueNumber = r.nextInt(15) + 1;
        arr[arr.length - 1] = blueNumber;
        return arr;
    }

    //用户输入号码
    public static int[] userInputNumber() {
        //创建数组添加用户购买号码
        int[] arr = new int[7];
        Scanner sc = new Scanner(System.in);
        //让用户输入红球号码
        for (int i = 0; i < 6; ) {
            System.out.println("请输入第" + (i + 1) + "个红球号码");
            int redNumber = sc.nextInt();
            //redNumber 在1~33之间且唯一不重复
            if (redNumber >= 1 && redNumber <= 33) {
                boolean flag = contains(arr, redNumber);
                if (!flag) {
                    arr[i] = redNumber;
                    i++;
                } else {
                    System.out.println("号码已存在，请重新输入");
                }
            } else {
                System.out.println("超出范围");
            }
        }
        //输入篮球号码
        System.out.println("请输入篮球号码");
        while (true) {
            int blueNumber = sc.nextInt();
            if (blueNumber >= 1 && blueNumber <= 16) {
                arr[arr.length - 1] = blueNumber;
                break;
            } else {
                System.out.println("当前号码不符合请重新输入");
            }
        }
        return arr;

    }

    //判断数字是否重复
    public static boolean contains(int[] arr, int number) {
        for (int i = 0; i < 7; i++) {
            if (arr[i] == number) {
                return true;
            }

        }
        return false;
    }


}

package Lianxi;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票的价格");
        int ticket = sc.nextInt();
        System.out.println("请输入当前月份");
        int month = sc.nextInt();
        System.out.println("请输入仓位 0表示头订舱，1为经济舱");
        int seat = sc.nextInt();

        //判断是旺季还是淡季
        if(month >= 5 && month <=10){
            //旺季
            if(seat==0){
                //头等舱
                ticket=(int)(ticket*0.9);
            }
            else if(seat==1){
                //经济舱
                ticket=(int)(ticket*0.85);
            }
            else{
                System.out.println("没有这个仓位");
            }
        }
        else if ((month >= 1 && month <=4) || (month >=11 && month <=12)){
            //淡季
            if(seat==0){
                //头等舱
                ticket=(int)(ticket*0.7);
            }
            else if(seat==1){
                //经济舱
                ticket=(int)(ticket*0.65);
            }
            else{
                System.out.println("没有这个仓位");
            }
        }
        else{
            System.out.println("月份不合法");
        }
        System.out.println(ticket);
    }





}

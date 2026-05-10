package second_day.pack.root;
import java.util.Scanner;
import second_day.pack.cal.*;

public class root {
    public static void main(String[] args){
        Scanner model_select = new Scanner(System.in);
        Scanner num_input = new Scanner(System.in);

        root.print_msg("請輸入運算模式：1->加法 2->減法 3->乘法 4->除法");
        int model = model_select.nextInt();

        root.print_msg("請數入數字一");
        double cal_num1 = num_input.nextInt();
        root.print_msg("請數入數字二");
        double cal_num2 = num_input.nextInt();
        root.cal(model,cal_num1,cal_num2);

        model_select.close();
        num_input.close();
    }
    static void print_msg(String message){
        System.out.println(message);
    }
    static void print_num(double num){
        System.out.println(num);
    }
    static void cal(int model,double cal_num1,double cal_num2){
        switch (model) {
            case 1:
                double add_result = add.add_num(cal_num1, cal_num2);
                print_num(add_result);
                break;
            case 2:
                double minus_result = minus.minus_num(cal_num1, cal_num2);
                print_num(minus_result);
                break;
            case 3:
                double mul_result = mulit.mulit_num(cal_num1, cal_num2);
                print_num(mul_result);
                break;
            case 4:
                double division_result = division.division_num(cal_num1, cal_num2);
                print_num(division_result);
                break;
            default:
                break;
        }
    }
}

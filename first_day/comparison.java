import java.util.Scanner;

public class comparison {
    public static void main(String[] args){
        // new一個新物件，指向Scanner記憶體位置
        Scanner s = new Scanner(System.in);

        //取得整數輸入
        int x = s.nextInt();
        System.err.println(x);

        //取得字串輸入(不能有空格)
        String y = s.next();
        System.out.println(y);

        s.close();
    }
}

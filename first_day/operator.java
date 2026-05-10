public class operator {
    public static void main(String[] args){
        int x = 5/2;
        double y = 5%3.5;

        System.out.println(x);
        System.out.println(y);

        boolean z = "Hello" == "Hello";
        System.out.println(z);

        int p = 1;
        System.out.println(p);
        p++; //後置遞增(Postincrement): 回傳後 +1
        System.out.println(p);
        ++p; //前置遞增(Preincremnet): +1 後回傳
        System.out.println(p);

        int a = 5;
        switch(a){
            case 1:
                System.out.println("YES 1");
                break;
            case 2:
                System.out.println("YES 2");
                break;
            case 3:
                System.out.println("YES 3");
                break;
            case 4:
                System.out.println("YES 4");
                break;
            case 5:
                System.out.println("YES 5");
                break;
            case 6:
                System.out.println("YES 6");
                break;
            default: //else 的概念
                System.out.println("Not in the list!");
                break;
        }
    }
}

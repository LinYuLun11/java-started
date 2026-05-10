import java.util.Scanner;

public class train_loop {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        for (int i=0; i<count; i++){
            int a = s.nextInt();
            long b = s.nextInt();
            long c = s.nextInt();

            switch(a){
                case 1:
                    System.out.printf("%d\n", b+c);
                    break;
                case 2:
                    System.out.printf("%d\n", b-c);
                    break;
                case 3:
                    System.out.printf("%d\n", b*c);
                    break;
                case 4:
                    System.out.printf("%d\n", b/c);
                    break;
                default:
                    break;
            }
        }
        s.close();
    }
}

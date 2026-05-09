public class loop {
    public static void main(String[] args){
        for (int i=1; i<5; i++){
            if(i%2 == 0){
                continue;
            }
            System.out.println(i);
        }
        int j = 0;
        while(true){
            System.out.println(j++);
            if(j>5){
                break;
            }
        }
    }
}

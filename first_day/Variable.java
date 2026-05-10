public class Variable{
    public static void main(String[] args){
        System.out.println(3);
        System.out.println(3000000000000L); //L -> Long
        System.out.println(3.14159265358F); //F -> Float 
        // Float 只取到小數點後第七位，後面的數字會四捨五入到第七位數

        String s1 = "123";
        int d1 = Integer.parseInt(s1);
        System.out.println(d1);
    }
}
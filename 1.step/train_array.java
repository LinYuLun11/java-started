import java.util.Scanner;

public class train_array {
    public static void main(String[] args){
        Scanner input_obj = new Scanner(System.in);

        int row = input_obj.nextInt();
        int col = input_obj.nextInt();

        int[][] origin = new int[row][col];
        int[][] transition = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0;j<col; j++){
                origin[i][j] = input_obj.nextInt();
            }
        }

        for(int j=0; j<col; j++){
            for(int i=0; i<row; i++){
                transition[j][i] = origin[i][j];
            }
        }

        for(int a=0; a<col; a++){
            for(int b=0; b<row; b++){
                System.out.printf("%d ",transition[a][b]);
            }
            System.out.println();
        }
        input_obj.close();
    }
}

package com.codingchamps.GeeksForGeeks;

public class SpiralMatrix {

	public static void main(String[] args) {
		
		System.out.print("Matrix : \n");
		int matrix[][] = new int[3][4];
        int count=1;
        for(int i=0;i<3;i++)
            for(int j=0;j<4;j++)
                matrix[i][j] = count++;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.print("\n");
                
        }
        
        
        int dir = 0;// 0,1,2,3
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int bottom = row-1;
        int left = 0;
        int right = col-1;
        System.out.print("\nSpiral View of Matrix : ");
        while(top<= bottom && left<=right){
            
            if(dir==0){
                for(int i = left; i<=right;i++)
                    System.out.print(matrix[top][i]+" ");
                top++;
            }
            else if(dir==1){
                for(int i = top; i<=bottom;i++)
                    System.out.print(matrix[i][right]+" ");
                right--;
            }
            else if(dir==2){
                for(int i = right; i>=left;i--)
                    System.out.print(matrix[bottom][i]+" ");
                bottom--;
            }
            else if(dir==3){
                for(int i = bottom; i>=top;i--)
                    System.out.print(matrix[i][left]+" ");
                left++;
            }
            dir = (dir +1)%4;
        }

	}

}

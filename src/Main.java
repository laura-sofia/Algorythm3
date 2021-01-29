import java.util.*;

/**
 *
 * @author sveta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        while(true){
            int n=scn.nextInt();
            int m=scn.nextInt();
            if (n==0)break;
            arr=new int[n][m];
            for (int i=0;i<n;i++)for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
            put();
        }
    }
    public static int[][]sum;
    public static int[][]arr;
    public static void put(){
        int n=arr.length;
        int m=arr[0].length;
        sum=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (i>0)sum[i][j]+=sum[i-1][j];
                if (j>0)sum[i][j]+=sum[i][j-1];
                if (j>0 && i>0)sum[i][j]-=sum[i-1][j-1];
                sum[i][j]+=arr[i][j];
            }
        }
        //int max=0;
        int min=0;
        for (int i=0;i<n;i++)for(int j=0;j<m;j++){
            for (int q=i;q<n;q++)for(int w=j;w<m;w++){
                
                int temp=sum[q][w];
                if (i>0)temp-=sum[i-1][w];
                if (j>0)temp-=sum[q][j-1];
                if (j>0 && i>0)temp+=sum[i-1][j-1];
                
               /* if (temp==(w-j)*(q-i)){
                    max=Math.max(max, temp);
                }*/
               
               if (temp==0){
                   min=Math.max(min,(w-j+1)*(q-i+1));
               }
                
            }
        }
        System.out.println(min);
    }
    
}

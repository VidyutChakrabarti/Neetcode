import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
     static int[] getNextSmallEle(int[] arr,int arrSize)
    {           
        int[] nextSmallEle = new int[arrSize];
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(-1);
        for (int i = arrSize - 1; i >= 0; i--) {
            while (stack1.peek() != -1 && arr[stack1.peek()] >= arr[i]) {
                stack1.pop();
            }
            nextSmallEle[i] = stack1.peek();
            stack1.push(i);

        }
        return nextSmallEle;

        
    }
    static int[] getPrevSmallEle(int[] arr,int arrSize)
    {           
       int[] prevSmallEle = new int[arrSize];
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(-1);
        for (int i = 0; i < arrSize; i++) {
            while (stack1.peek() != -1 && arr[stack1.peek()] >= arr[i]) {
                stack1.pop();
            }
            prevSmallEle[i] = stack1.peek();
            stack1.push(i);

        }
        return prevSmallEle;

        
    }
    static long getLargestHistogram(int[] arr,int arrSize)
    {           
               
    int[] prevSmallEleIndex=new int[arrSize];
    int[] nextSmallEleIndex=new int[arrSize];
    
 
    
    nextSmallEleIndex = getNextSmallEle(arr,arrSize);
     
    prevSmallEleIndex = getPrevSmallEle(arr,arrSize);
      
    long width=0;
    long tempwidth=0;
    long length=0;
     for(int i=0;i<arrSize;i++)
    {
        length=arr[i];
       if(nextSmallEleIndex[i]==-1)
      {
          nextSmallEleIndex[i]=arrSize;
      }
          
       tempwidth=(nextSmallEleIndex[i]-prevSmallEleIndex[i]-1)*length;
       width=Math.max(width,tempwidth);
    }
        return width;
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] elements1 = br.readLine().split(" ");

		int rows = Integer.parseInt(elements1[0]);
		int cols = Integer.parseInt(elements1[1]);
		int[][] yard= new int[rows][cols];
		 String[] elements2=new String[cols];
		  for (int i = 0; i < rows; i++) {
		  elements2 = br.readLine().split(" ");

            for (int j = 0; j < cols; j++) {
                yard[i][j] =  Integer.parseInt(elements2[j]);

            }
         }
          int[] tempHistogram= new int[cols];
      
       
        long maxYardArea=0;

         for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                  if(yard[i][j]==1)
                  {
                      tempHistogram[j]=tempHistogram[j]+1;
                  }
                  else
                  {
                      tempHistogram[j]=0;
                  }
               
            }
          

          maxYardArea= Math.max(maxYardArea,getLargestHistogram(tempHistogram,cols));
        }
           out.println(maxYardArea + " ");
        out.flush();
        out.close();
        br.close();
	}
}
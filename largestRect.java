class largestRect
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long[] prevSmall= getPrevSmall(hist);
        long[] nextSmall= getNextSmall(hist);
        
        long maxArea=0L;
        
        for(int i=0; i<n; i++){
            long area= (nextSmall[i]-prevSmall[i]-1)*hist[i];
            maxArea= Math.max(area, maxArea);
        }
        
        
        return maxArea;
        
        
    }
    
    
    public static long[] getPrevSmall(long[] arr){
        
        long[] prevSmall= new long[arr.length];
        
        Stack<Integer> s= new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            
            while(!s.isEmpty() && arr[s.peek()]>= arr[i] ){
                s.pop();
            }
            
            prevSmall[i]= s.isEmpty()? -1 : s.peek();
            
            s.push(i);
        }
        
        return prevSmall;
    }
    
    public static long[] getNextSmall(long[] arr){
        
        long[] nextSmall= new long[arr.length];
        
        Stack<Integer> s= new Stack<>();
        
        for(int i=arr.length-1; i>=0; i--){
            
            while(!s.isEmpty() && arr[s.peek()]>= arr[i] ){
                s.pop();
            }
            
            nextSmall[i]= s.isEmpty()? arr.length : s.peek();
            
            s.push(i);
        }
        
        return nextSmall;
    }
}
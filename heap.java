//GFG https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1

class heap
{
    //Max- heap contains element from stream <= Meadian present at top Max-Heap
    static PriorityQueue<Integer> smallest= new PriorityQueue<>(Collections.reverseOrder());
    //Min- heap contains element from stream > Meadian present at top of Max-Heap
    static PriorityQueue<Integer> largest= new PriorityQueue<>();
    
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        
        //start filling from max-Heap
        if(smallest.isEmpty() || x<=smallest.peek()){
            smallest.add(x);
        }else{
            largest.add(x);
        }
        
        //start balancing if required
       balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
        //when max-Heap get imbalance
        if(smallest.size()>largest.size()+1){
           largest.add(smallest.poll());
       }
       
       //when min-Heap get imbalance
       else if(smallest.size()<largest.size()){
           smallest.add(largest.poll());
       }
       
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        //means stream has even no of elements
        if(largest.size()== smallest.size()){
            return ((smallest.peek()+ largest.peek())/2.0);
        }
        
        //means stream has odd no of elements
        return smallest.peek();
    }
    
}
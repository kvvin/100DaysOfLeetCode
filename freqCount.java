class freqCount{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int n, int P)
    {
        // code here
        Arrays.sort(arr);
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            if(!mp.containsKey(arr[i]))
            mp.put(arr[i], 1);
            else
            mp.put(arr[i], mp.get(arr[i])+1);
        }
        for(int j=0; j<n; j++){
            if(!mp.containsKey(j+1))
            arr[j]=0;
            else
            arr[j]=mp.get(j+1);
        }
    }
}
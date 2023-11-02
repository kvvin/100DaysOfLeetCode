
class mergeArr
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int i=0,j=0;
        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
                i++;
            }
            else{
                long temp1 = arr1[n-1];
                arr1[n-1]=arr2[j];
                arr2[j]=temp1;
                j++;
                n--;
                }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
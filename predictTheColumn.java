class predictTheColumn
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        // code here
        int i=0;
        int j=0;
        int max_zero=0;
        int ans=-1;
        for(i=0;i<N;i++){
            int curr_zero=0;
            for(j=0;j<N;j++){
                if(arr[j][i]==0){
                    curr_zero++;
                }
            }
        if(curr_zero>max_zero){
            ans=i;
        }
        max_zero=Math.max(curr_zero,max_zero);
        }
        return ans;
    }
}
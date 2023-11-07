class Solution
{
    //Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        // code here
        int totalSum=0, lowerSum=0;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(j<=i){
                    lowerSum+=matrix[i][j];
                }
                if(j==i){
                    totalSum+=matrix[i][j];
                }
                totalSum+=matrix[i][j];
                
            }
        }
        ans.add(totalSum-lowerSum);
        ans.add(lowerSum);
        return ans;
    }
}
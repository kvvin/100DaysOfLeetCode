class snakePattern
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
        int col = matrix[0].length;
        int row = matrix.length ;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        
        for(int i = 0 ;i< row ; i++){
            
            if(i%2 == 0 ){
                
                  for(int j = 0 ; j < col ; j++){
                    list.add(matrix[i][j]);  
                  }  
            }
            
            else{
                
             for(int j = col-1 ; j >=0 ; j--){
                    list.add(matrix[i][j]);  
                  } 
        
        }
        
        
        
    }
    
    return list; 
    }
}
class printNumberForPattern{
    static String printMinNumberForPattern(String S){
    
        int check=1;
        char arr[] = new char[9];
        String sol="";
        for(int i=0;i<=S.length();i++){
            if(i==S.length() || S.charAt(i) == 'I'){
                for(int j = i-1;j>=-1;j--){
                    arr[j+1] = (char)('0' + check);
                    check++;
                    if(j>=0 && S.charAt(j)=='I'){
                        break;
                    }
                }
            }
        }
        for(int i=0;i<=S.length();i++){
            sol+=arr[i];
        }
        return sol;
    }
}

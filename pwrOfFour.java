class pwrOfFour {
    public boolean isPowerOfFour(int n) {
        int m = 0x55555555;
        return n> 0 &&(n&(n-1)) == 0 && (n&m) == n;
        
    }
}
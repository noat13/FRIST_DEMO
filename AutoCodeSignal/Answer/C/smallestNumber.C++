int smallestNumber(int n) {
    int x;
    if(n == 1){
        return 0;
    }
    else {
        x = 1;
        n--;
        while(n){
            x*=10;
            n--;
        }
    }
    
    return x;
}

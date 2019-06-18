bool sameDigitNumber(int n) {
 if(n>=0 && n<=9) return true;
 
 int digit = n%10;
 while(n>0)
 {
    if(n%10!=digit) return false;
    
    n = n/ 10 ;
 }
 
 return true;
}

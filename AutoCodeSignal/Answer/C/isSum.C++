bool isSum(int value) {

    for(int i = 1; ; i++)
    {
        int sum = 0;
        for(int j = 1; j <= i; j++)
        {
            sum += j;
        }
        if(sum == value) return true;
        if(sum > value) return false;
    }
    
}

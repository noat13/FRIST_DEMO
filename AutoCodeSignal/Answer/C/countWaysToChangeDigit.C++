int countWaysToChangeDigit(int value) {
    int ans = 0;
    while(value)
    {
        ans += 9 - (value % 10);
        value /= 10;
    }
    return ans;
}

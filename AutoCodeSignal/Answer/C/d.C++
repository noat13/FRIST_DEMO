int d(int x) {
    int ans = 0;
    for (int i = 1; i <= x; i++) {
        ans += x % i == 0;
    }
    return ans;
}
int divNumber(int k, int l, int r) {
    int ans = 0;
    for (int i = l; i <= r; i++) {
        ans += d(i) == k;
    }
    return ans;
}

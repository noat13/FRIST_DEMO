int s(int x) {
    int res = 0;
    while (x) {
        res += x % 10;
        x /= 10;
    }
    return res;
}
bool ok(int a, int b) {
    int sum = s(a);
    return a != b && a - sum <= b && b <= a + sum;
}
int comfortableNumbers(int l, int r) {
    int ans = 0;
    for (int a = l; a <= r; a++) {
        for (int b = a + 1; b <= r; b++) {
            ans += ok(a, b) && ok(b, a);
        }
    }
    return ans;
}

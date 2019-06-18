int kthDigit(int n, int k) {
  string s = to_string(n);
  return k <= s.size() ? s[k - 1] - '0' : -1;
}

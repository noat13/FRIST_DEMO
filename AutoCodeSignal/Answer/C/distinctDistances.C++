int distinctDistances(std::vector<int> d) {
    int a = d[0];
    int b = d[1];
    int c = d[2];
    if (a + b >= c && a + c >= b && b + c >= a) {
        return 3;
    }
    return 4;
}

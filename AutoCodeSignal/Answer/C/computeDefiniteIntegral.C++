double computeDefiniteIntegral(int l, int r, std::vector<int> p) {
    double t = 0;
    double L = 1, R = 1;
    int i = 0;
    for (int x : p) {
        ++i;
        L *= l;
        R *= r;
        t += x*(R-L)/i;
    }
    return t;
}
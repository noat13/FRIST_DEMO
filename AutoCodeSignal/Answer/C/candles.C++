int candles(int can, int mak) {
    int lef = can, res = can;
    can = 0;
    while (can > 0 || lef >= mak) {
        lef += can;
        res += can;
        can = lef / mak;
        lef %= mak;
    }
    return res;
}

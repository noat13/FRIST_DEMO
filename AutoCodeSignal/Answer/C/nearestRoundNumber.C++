int nearestRoundNumber(int value) {
    while (value % 10 != 0)
        ++value;
    return value;
}

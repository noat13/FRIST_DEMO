int minimalMultiple(int divisor, int lowerBound) {
        if (lowerBound % divisor == 0) {
            return lowerBound;
        }
        return (lowerBound / divisor + 1) * divisor;
    }
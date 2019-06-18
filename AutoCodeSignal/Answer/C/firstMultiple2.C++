int firstMultiple2(std::vector<int> divisors, int start) {
    for(int i = start; i < 999999999; i++) {
        for(int j = 0; j < divisors.size();++j) {
            if(i%divisors[j] == 0) return i;
        }
    }
}

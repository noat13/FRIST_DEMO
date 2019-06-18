std::string compareIntegers(std::string a, std::string b) {
    long long an = stol(a);
    long long bn = stol(b);
    if(an < bn) return "less";
    else if(an == bn) return "equal";
    else return "greater";
}

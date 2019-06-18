int sumUpDigits(std::string inputString) {
    int r = 0;
    for(int i = 0; i < inputString.size(); i++){
        if(inputString[i] <= '9' && inputString[i] >= '0')  r += inputString[i]-'0';
    }
    return r;
}

char lastDigitRegExp(std::string inputString) {
    for(int i = inputString.length() - 1; i >= 0; i--)
    {
        if(inputString[i] >= '0' && inputString[i] <= '9') return inputString[i];
    }
}

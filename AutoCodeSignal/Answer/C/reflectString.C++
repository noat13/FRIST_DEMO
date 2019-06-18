std::string reflectString(std::string inputString) {
    for(int i = 0; i < inputString.length(); i++)
    {
        inputString[i] = 'a' - inputString[i] + 'z';
    }
    return inputString;
}

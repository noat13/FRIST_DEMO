bool isCorrectSentence(std::string inputString) {
    if(isupper(inputString[0])&&inputString[inputString.length()-1]=='.')return true;
    return false;
}

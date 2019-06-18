bool coolString(std::string inputString) {
    for (int i = 0; i < inputString.size(); ++i) {
        if (!isalpha(inputString[i])) {
            return false;
        }
    }
    for (int i = 1; i < inputString.size(); ++i) {
        if (isupper(inputString[i - 1]) == isupper(inputString[i])) {
            return false;
        }
    }
    return true;
}

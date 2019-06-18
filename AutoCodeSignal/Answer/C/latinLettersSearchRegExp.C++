bool latinLettersSearchRegExp(std::string input) {
    for(auto x : input)
        if (x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z')
            return true;
    return false;
}

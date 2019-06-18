bool alphabetSubstring(std::string s) {
    for (int i = 1; i < s.length(); i++)
    {
        if ((int)s[i] - (int)s[i - 1] != 1)
            return false;
    }
    return true;
}

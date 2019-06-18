int telephoneGame(std::vector<std::string> messages) {
    string orig = messages[0];
    for(int i = 1; i < messages.size(); i++)
    {
        if(messages[i] != orig) return i;
    }
    return -1;
}

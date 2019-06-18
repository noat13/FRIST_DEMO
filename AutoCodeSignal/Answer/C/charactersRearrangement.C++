bool charactersRearrangement(std::string string1, std::string string2) {
    unordered_map<char, int> list;
    for(int i = 0; i < string1.length();++i) {
        list[string1[i]]++;
    }
    for(int i = 0; i < string2.length();++i) {
        if(list.find(string2[i]) == list.end()) return false;
        else list[string2[i]]--;
    }
    for(auto it = list.begin(); it != list.end(); ++it) {
        if((*it).second != 0) return false;
    }
    return true;
}

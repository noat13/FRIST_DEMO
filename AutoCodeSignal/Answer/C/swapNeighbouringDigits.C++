int swapNeighbouringDigits(int n) {
    string word = to_string(n);
    for(int i = 0; i < word.size(); i+=2) {
        char temp = char(word[i]);
        word[i] = word[i+1];
        word[i+1] = int(temp);
    }
    return stoi(word);
}

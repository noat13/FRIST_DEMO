string capitalizeVowelsRegExp(string input) {
    for(auto &i:input)
        if(i=='a' || i=='e' || i=='i' || i=='o' || i=='u' || i=='y') i-=32;
    return input;
}
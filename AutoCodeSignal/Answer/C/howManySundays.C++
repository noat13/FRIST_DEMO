int howManySundays(int n, std::string startDay) {
    map<string, int> dic;
    
    dic.insert(make_pair("Monday", 1));
    
    dic.insert(make_pair("Tuesday", 2));

    dic.insert(make_pair("Wednesday", 3));

    dic.insert(make_pair("Thursday", 4));

    dic.insert(make_pair("Friday", 5));

    dic.insert(make_pair("Saturday", 6));

    dic.insert(make_pair("Sunday", 7));
    
    int count = dic[startDay] + n;
    
    if (startDay == "Sunday")
        return count / 7 - 1;
    else 
    
    return count / 7;

        
}

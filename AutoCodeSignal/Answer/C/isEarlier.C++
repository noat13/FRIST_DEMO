bool isEarlier(std::vector<int> time1, std::vector<int> time2) {
    
    if(time1[0]<time2[0])
        return true;
    
    if(time1[0]==time2[0] && time1[1]<time2[1])
        return true;
    
    return false;
}

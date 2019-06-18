bool areIsomorphic(std::vector<std::vector<int>> array1, std::vector<std::vector<int>> array2) {

    int tab[10000];
    
    if(array1.size()!=array2.size())
    {
        return false;
    }
    for(int i=0; i<array1.size(); i++)
    {
        tab[i] = array1[i].size();
    }
    
    for(int i=0; i<array2.size(); i++)
    {
        if(array2[i].size()!=tab[i])
            return false;
    }
    
    return true;
}

std::string stolenLunch(std::string note) {
    for (auto &i:note)
    {
        if(i>='a' && i<='j') i=(i-'a')+'0';
        else if(i>='0' && i<='9') i+=49;
    }
    return note;
}

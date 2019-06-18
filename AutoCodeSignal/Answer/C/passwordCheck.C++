bool passwordCheck(std::string inputString) {
if(inputString.size()<5)return false;
int capit=0,small=0,digit=0;
    for(int i=0;i<inputString.size();i++)
    {
        if(inputString[i]>='A' and inputString[i]<='Z')capit=1;
        if(inputString[i]>='a' and inputString[i]<='z')small=1;
        if(inputString[i]>='0' and inputString[i]<='9')digit=1;
    }
    if(capit==1 and small==1 and digit==1)return true;
    return false;
}

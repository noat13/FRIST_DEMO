std::string caseUnification(std::string inputString) {

    int lowerCount = 0;
    for(int i = 0; i < inputString.length(); i++)
    {
        if(inputString[i] >= 'a' && inputString[i] <= 'z') 
        {
            lowerCount++;
        }
    }
    
    if(lowerCount > inputString.length() / 2)
    {
        for(int i = 0; i < inputString.length(); i++)
        {
            if(inputString[i] >= 'A' && inputString[i] <= 'Z')
            {
                inputString[i] += 32;
            }
        }
    }
    else
    {
        for(int i = 0; i < inputString.length(); i++)
        {
            if(inputString[i] >= 'a' && inputString[i] <= 'z')
            {
                inputString[i] -= 32;
            }
        }
    }
    
    return inputString;
}

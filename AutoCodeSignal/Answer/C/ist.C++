bool ist(int n)
{
    string s = to_string(n);
    bool k = true;
    for(int i = 1; i < s.length(); i++)
    {
        if(s[i] != '0')
        {
            k = false;
            break;
        }
    }
    return k;
}

int getKthDigit(int n, int k)
{
    string s = to_string(n);
    return s[s.length() - k - 1] - '0';
}

int rounders(int n) {
    
    int index = 0;
    while(!ist(n))
    {
        int x = getKthDigit(n, index);
        if(x < 5)
        {
            n -= x * pow(10, index);            
        }
        else
        {
            n += (10 - x) * pow(10, index);
        }
        
        index++;
    }
    return n;
}

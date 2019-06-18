int differentValues(std::vector<int> a, int d) {
    
    int ans = -1;
    for(int i = 0; i < a.size() - 1; i++)
    {
        for(int j = i + 1; j < a.size(); j++)
        {
            int x = abs(a[i] - a[j]);
            if(x <= d)
            {
                ans = max(ans, x);
            }
        }
    }
        
    return ans;
}

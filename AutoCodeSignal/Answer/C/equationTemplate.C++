bool equationTemplate(std::vector<int> values) {
    for(int i = 0; i < values.size(); i++)
    {
        int mult = 1;
        for(int j = 0; j < values.size(); j++)
        {
            if(i == j) continue;
            mult *= values[j];
        }
        if(mult == values[i]) return true;
    }
    
    for(int i = 0; i < values.size(); i++)
    {
        for(int j = 0; j < values.size(); j++)
        {
            if(i == j) continue;
            int curr = values[i] * values[j];
            int currone = 1;
            for(int k = 0; k < values.size(); k++)
            {
                if(k == i || k == j) continue;
                currone *= values[k];
            }
            if(currone == curr) return true;
        }
    }
    return false;
}

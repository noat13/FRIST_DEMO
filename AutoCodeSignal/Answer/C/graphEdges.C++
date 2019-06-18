int graphEdges(std::vector<std::vector<bool>> matrix) {
    int ans = 0;
    for(int i = 0; i < matrix.size(); i++)
    {
        for(int j = 0; j < matrix.size(); j++)
        {
            if(matrix[i][j] && i < j) ans++;
        }
    }
    return ans;
}

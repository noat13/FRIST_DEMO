int matrixElementsSum(std::vector<std::vector<int>> matrix) {
    int sum = 0;
    for (int i = 0; i < matrix.size(); i++)
    {
        for (int j = 0; j < matrix[i].size(); j++)
        {
            bool f = false;
            for (int k = i; k >= 0; k--)
            {
                if (matrix[k][j] == 0)
                    f = true;
            }
            if (!f)
                sum += matrix[i][j];
        }
    }
    return sum;
}

int differentSquares(std::vector<std::vector<int>> matrix) {
    set<pair<pair<int,int>,pair<int,int> > > secik;
    for(int i = 0; i + 1 < matrix.size(); i++){
        for(int j = 0; j + 1 < matrix[0].size(); j++){
            secik.insert(make_pair(make_pair(matrix[i][j],matrix[i][j+1]),make_pair(matrix[i+1][j],matrix[i+1][j+1])));
        }
    }
    return secik.size();
}

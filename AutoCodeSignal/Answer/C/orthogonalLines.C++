bool orthogonalLines(std::vector<int> line1, std::vector<int> line2) {
    return line1[0] * line2[0] + line1[1] * line2[1] == 0;
}

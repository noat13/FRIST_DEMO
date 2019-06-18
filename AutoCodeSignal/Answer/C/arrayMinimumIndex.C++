int arrayMinimumIndex(std::vector<int> v) {
    auto itr = min_element(v.begin(), v.end());
    return itr - v.begin();
}

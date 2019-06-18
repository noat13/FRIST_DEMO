bool insideCircle(std::vector<int> point, std::vector<int> center, int radius) {
    return (point[0]-center[0])*(point[0]-center[0])+(point[1]-center[1])*(point[1]-center[1]) <= radius*radius;
}

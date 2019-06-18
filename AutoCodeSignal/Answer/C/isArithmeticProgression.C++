func isArithmeticProgression(sequence: [Int]) -> Bool {
    var s = Set<Int>()
    for (x,y) in zip(sequence[1...], sequence) {
        s.insert(x - y)
    }
    return s.count == 1
}

int chessBoardSquaresUnderQueenAttack(int a, int b) {
swap(a,a>b?b:a);
    return a*b*~-b + a*~-a*(3*b+~a/1.5);
}

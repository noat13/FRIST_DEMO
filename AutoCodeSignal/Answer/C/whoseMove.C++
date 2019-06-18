std::string whoseMove(std::string lastPlayer, bool win) {
    if(win) return lastPlayer;
    else return lastPlayer == "black" ? "white" : "black";
}

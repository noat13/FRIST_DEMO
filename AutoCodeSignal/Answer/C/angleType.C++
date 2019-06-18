std::string angleType(int m) {

    if( m < 90 ) {
        return "acute";
    } else if ( m == 90 ) {
        return "right";
    } else if( m < 180 ) {
        return "obtuse";
    } else {
        return "straight";
    }
    
}

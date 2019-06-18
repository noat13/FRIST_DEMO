function arrayMinimumAboveBound($inputArray, $bound) {
    return min(array_filter($inputArray, function($v) use($bound){
        return $v > $bound;
    }));
}

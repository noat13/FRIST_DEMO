int[][] create2DArray(int[] lengths) {
    List<int[]> r = new List<int[]> ();
    foreach(var i in lengths){
        List<int> s = new List<int>();
        for(int j = 0; j< i; j++){
            s.Add(j);
        }
        r.Add(s.ToArray());
    }
    return r.ToArray();
}

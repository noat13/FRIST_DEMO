function strangeCode($s, $e) {
$t=["a","b"];
$i=0;
$r="";
while ($s<$e-1)
    {
    $s++;
    $e--;
    $r.=$t[$i%2];
    $i++;
    }
return $r;

}

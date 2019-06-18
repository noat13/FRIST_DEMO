function equationSolutions($l, $r) {
$n=0;
for ($i=$l;$i<=$r;$i++)
    for ($j=$i;$j<=$r;$j++)
        if ($i**3 == $j**2 || $i**2 == $j**3)
            $n++;
return $n;

}

function divisorsPairs($sequence) {
$l=count($sequence);
    sort($sequence);
$nb=0;
for ($i=0;$i<$l-1;$i++)
    for ($j=$i+1;$j<$l;$j++)
        if ($sequence[$j]%$sequence[$i]==0)
            $nb++;
return $nb;

}

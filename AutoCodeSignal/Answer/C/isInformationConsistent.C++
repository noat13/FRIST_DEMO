function isInformationConsistent($evidences) {
for ($i=0;$i<count($evidences[0]);$i++)
    {
    $b = array_column($evidences,$i);
    $j=0;
    while ($b[$j]===0 && $j<count($b))
        $j++;
    $p=$b[$j++];
    while ($j<count($b))
        {
        if ($b[$j]==-$p)
            return false;
        $j++;
        }
    }
return true;

}

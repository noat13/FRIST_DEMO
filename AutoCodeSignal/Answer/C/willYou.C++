bool willYou(bool young, bool beautiful, bool loved) {
 	if(young == true && beautiful == true && loved == false)
        return true;
    else if (loved == true && (young == false || beautiful == false))
        return true;

   	return false;
}

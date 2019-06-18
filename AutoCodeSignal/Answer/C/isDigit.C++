bool isDigit(char symbol) 
{
    try 
    {
        Convert.ToInt32(Convert.ToString(symbol));
        return true;
    }
    catch 
    {
        
    }
    return false;
}

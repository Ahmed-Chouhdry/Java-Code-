public class NumberDisplay
{
    private int limit;
    private int value;
	private String ph;
	private int timer;
  
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 0;
        timer = 2;
    }

    public int getValue()
    {
        return value;
    }

   
    public String getDisplayValue()
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
      //  if(value < 12){
       // 	if(value<10)
       // 		return "0"+value;
       // 	return value"AM";
        //}
        //else
       // 	return "PM";
        
    }
    public String getPhase()
    {
    
    	if (timer!=1)
    	{
    	if (value<12)
    	{
    	
    		ph= "AM";
    	}
    	else{
    		
    		ph= "PM";
    	
    		}
    	timer =1;
    	}
    	return ph;
    }

    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    
    public void increment()
    {
        value = (value + 1) % limit;
    }
}

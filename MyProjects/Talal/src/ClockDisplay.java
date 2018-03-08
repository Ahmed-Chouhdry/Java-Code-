public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String phase;	// extra
    private String displayString;
    private NumberDisplay s;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        phase = "AM";
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute,int second)
    {
    	phase = "AM";
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        setTime(hour, minute,second);
    }

  
    public void timeTick()
    {
    	seconds.increment();
    	if(seconds.getValue()==0)
    	{
    		minutes.increment();
        	if(minutes.getValue() == 0) {  // it just rolled over!
            	hours.increment();
            	
        	}
    	}
    	if(hours.getValue()<12 )
            		phase = "AM";
        else if(hours.getValue()==12 )
            		phase ="NOON";
            	else
            	{
            	//	hours.getValue()=hours.getValue()-12;
            		phase = "PM";
            	}
        updateDisplay();
    }

   
    public void setTime(int hour, int minute, int second)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        updateDisplay();
    }

    public String getTime()
    {
    	System.out.println("The hell with time>> "+ displayString);
        return displayString;
    }
   
    private void updateDisplay()
    {
    	if (hours.getValue()<=12)
    	{
        	displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + ":" + seconds.getDisplayValue()+" "+ phase;
    	}
    	else{
    		int x=hours.getValue()-12;
    	displayString = x + ":" + minutes.getDisplayValue() + ":" + seconds.getDisplayValue()+" "+phase;
    	}
    		 
    }
}
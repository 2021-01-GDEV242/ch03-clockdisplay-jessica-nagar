
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Jessica Nagar
 * @date   02.08.2021
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String amPm;
    private int displayHours;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(25);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String am_pm)
    {
        hours = new NumberDisplay(25);
        minutes = new NumberDisplay(60);
        amPm = am_pm;
        setTime(hour, minute, am_pm);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if(hours.getValue() >= 13)
                amPm = "pm";
            else
                amPm = "am";
            
            if(hours.getValue() == 0)
            {
                hours.increment();
            }
            else if(hours.getValue() > 0)
            {
                System.out.println();
            }
            else
            {
                System.out.println("error");
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String am_pm)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        amPm = am_pm;
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        switch(hours.getValue())
        {
            case 1:
                displayHours = 1;
                break;
            case 2:
                displayHours = 2;
                break;
            case 3:
                displayHours = 3;
                break;
            case 4:
                displayHours = 4;
                break;
            case 5:
                displayHours = 5;
                break;
            case 6:
                displayHours = 6;
                break;
            case 7:
                displayHours = 7;
                break;
            case 8:
                displayHours = 8;
                break;
            case 9:
                displayHours = 9;
                break;
            case 10:
                displayHours = 10;
                break;
            case 11:
                displayHours = 11;
                break;
            case 12:
                displayHours = 12;
                break;
            case 13:
                displayHours = 1;
                break;
            case 14:
                displayHours = 2;
                break;
            case 15:
                displayHours = 3;
                break;
            case 16:
                displayHours = 4;
                break;
            case 17:
                displayHours = 5;
                break;
            case 18:
                displayHours = 6;
                break;
            case 19:
                displayHours = 7;
                break;
            case 20:
                displayHours = 8;
                break;
            case 21:
                displayHours = 9;
                break;
            case 22:
                displayHours = 10;
                break;
            case 23:
                displayHours = 11;
                break;
            case 24:
                displayHours = 12;
                break;
            default:
                displayHours = 0;
        }
        
        displayString = displayHours + ":" + 
                        minutes.getDisplayValue() + " " + amPm;
    }
}

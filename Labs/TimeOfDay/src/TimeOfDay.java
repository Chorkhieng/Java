import java.time.LocalDateTime;

// Java detail: We'll mark this as 'final' because it is not intended
// to be inherited from.
public final class TimeOfDay implements Comparable<TimeOfDay>{

    // Instance data
    // Every TimeOfDay object gets its own copy of each
    // instance variable.

    private int hour;
    private int minute;
    private int second;

    // Private methods
    // This cannot be called directly by clients; they are for
    // internal use only.

    // fix() is the magic behind maintaining the invariant of the
    // TimeOfDay class.  It allows us to just bump the number of
    // seconds (or minutes or hours) and call fix() to fix it
    // all up by applying any extra seconds to the minutes, and
    // so on.
    //
    // I have not taken the time to determine what will happen if
    // any of the instance variables are negative, so far now the
    // caller should ensure that that doesn't happen.
    private int fix() {

        int extra_minutes = this.second / 60;
        this.second %= 60;

        this.minute += extra_minutes;
        int extra_hours = this.minute / 60;
        this.minute %= 60;

        this.hour += extra_hours;
        int extra_days = this.hour / 24;
        this.hour %= 24;

        return extra_days;
    }

    // Constructors
    // These set up a new object

    // Default constructor - a constructor with no parameters
    // is called the "default constructor".
    public TimeOfDay() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    // Copy constructor.  This can be used to make a new copy
    // of an existing TimeOfDay object.
    public TimeOfDay(TimeOfDay other) {
        this.hour   = other.hour;
        this.minute = other.minute;
        this.second = other.second;
    }

    public TimeOfDay(int hour, int minute, int second) {
        assert 0 <= hour   && hour   < 24;
        assert 0 <= minute && minute < 60;
        assert 0 <= second && second < 60;

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public TimeOfDay(int secondsSinceMidnight) {
        assert secondsSinceMidnight >= 0;
        this.second = secondsSinceMidnight;
        fix();
    }

    // Static methods (functions)
    // These are not applied to any specific object.  They are called
    // using the classname.method() syntax.

    public static TimeOfDay now() {
        LocalDateTime ldtNow = LocalDateTime.now();
        return new TimeOfDay(ldtNow.getHour(), ldtNow.getMinute(),
                ldtNow.getSecond());
    }

    // Instance methods
    // These must be applied to a specific object using the obj.method()
    // syntax.  That object becomes 'this' within the method.

    public int addSeconds(int numSeconds) {
        this.second += numSeconds;
        return fix();
    }

    public int secondsSinceMidnight() {
        return this.hour * 3600 + this.minute * 60 + this.second;
    }

    // Getters
    // Methods that simply return one of the instance variables is referred
    // to as a "getter".

    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getSecond() {
        return second;
    }

    // See Sedgewick and Wayne, page 103, for how to properly
    // implement equals().
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        TimeOfDay tod = (TimeOfDay)other;
        return this.hour == tod.hour && this.minute == tod.minute
                && this.second == tod.second;
    }

    @Override
    public int compareTo(TimeOfDay compare){
        if (this.hour < compare.hour) return -1;
        if (this.hour > compare.hour) return 1;
        if (this.minute < compare.minute) return -1;
        if (this.minute > compare.minute) return 1;
        if (this.second < compare.second) return -1;
        if (this.second > compare.second) return 1;
        return 0;
    }


    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour,
                this.minute, this.second);
    }

    public static void main(String[] args) {
        TimeOfDay tod = TimeOfDay.now();
        System.out.printf("%s\n", tod);
        System.out.printf("%d seconds since midnight\n",
                tod.secondsSinceMidnight());

        TimeOfDay tod1 = new TimeOfDay(23, 59, 59);
        System.out.printf("%d seconds since midnight\n",
                tod1.secondsSinceMidnight());

        int days = tod1.addSeconds(2);
        System.out.printf("%s, %d day(s) later\n", tod1, days);
        System.out.printf("%d seconds since midnight\n",
                tod1.secondsSinceMidnight());

        TimeOfDay[] todArray = new TimeOfDay[4];
    }
}

public class Time {
    //instance variables
    private int hour;
    private int minute;
    private int second;

    //constructors are special methods that are invoked when an object is created.
    //has to be the same name as the class
    public Time() {
        //"this" is saying to use the variables that are IN this class, not the ones from above.
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void increment(int second) {
        this.second = second + this.second;
        this.minute = this.minute + (this.second / 60);
        this.hour = this.hour + (this.minute / 60);
        this.second = this.second % 60;
        this.minute = this.minute % 60;
        this.hour = this.hour % 24;
        new Time(hour, minute, second);
    }

    public void print(boolean military) {
        if (military) {
            System.out.println(String.format("%02d:%02d:%02d", hour, minute, second));
        } else {
            if (this.hour == 0) {
                int newHour = 12;
                System.out.println(String.format("%02d:%02d:%02d AM", newHour, minute, second));
            } else if (this.hour > 12) {
                int newHour = this.hour - 12;
                System.out.println(String.format("%02d:%02d:%02d PM", newHour, minute, second));
            } else {
                System.out.println(String.format("%02d:%02d:%02d AM", hour, minute, second));
            }
        }

    }

    public static Time fromString(String str) {
        String[] convert = str.split(":", 3);
        int hour = Integer.parseInt(convert[0]);
        int minute = Integer.parseInt(convert[1]);
        int second = Integer.parseInt(convert[2]);
        return new Time(hour, minute, second);
    }
}


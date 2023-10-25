public class Time {
    //instance variables
    private int hour;
    private int minute;
    private double second;

    //constructors are special methods that are invoked when an object is created.
    //has to be the same name as the class
    public Time() {
        //"this" is saying to use the variables that are IN this class, not the ones from above.
        this.hour = 0;
        this.minute = 0;
        this.second = 0.0;
    }

    public Time(int hour, int minute, double second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void increment(double second) {
        int newSecond = (int) second / 60;
        second = second % 60;
        minute = newSecond + minute;
        while (minute >= 60) {
            minute = minute - 60;
            int addHour = minute/60;
            hour = hour + addHour;
        }
        new Time(hour, minute, second);
    }

    public void print(boolean military) {
        if (true) {
            System.out.println(hour + ":" + minute + ":" + second);
        } else {
            int newHour = 24 - hour;
            System.out.println(newHour + ":" + minute + ":" + second);
        }
    }

    public static void fromString() {
        String[] convert = String.split(":", 3);
        int hour = Integer.parseInt(convert[0]);
        int minute = Integer.parseInt(convert[1]);
        int second = Integer.parseInt(convert[2]);
        new Time(hour, minute, second);
    }
}
}

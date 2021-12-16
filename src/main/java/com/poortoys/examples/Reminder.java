package com.poortoys.examples;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
    Timer timer;

    public Reminder() {
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.HOUR_OF_DAY, 10);
    	calendar.set(Calendar.MINUTE, 29);
    	calendar.set(Calendar.SECOND, 0);
    	Date time = calendar.getTime();

    	timer = new Timer();
    	timer.schedule(new RemindTask(), time);
	}

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Timesheet opening");
            ReminderUtils.displayTray();
//            ReminderUtils.doAction();
            timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        new Reminder();
    }
}

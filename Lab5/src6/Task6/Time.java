package src6.Task6;

import java.time.LocalTime;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        setTime(hours, minutes, seconds);
    }

    public Time() {
        LocalTime now = LocalTime.now();
        this.hours = now.getHour();
        this.minutes = now.getMinute();
        this.seconds = now.getSecond();
    }

    private void setTime(int hours, int minutes, int seconds) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Ошибка: часы должны быть от 0 до 23");
        }
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Ошибка: минуты должны быть от 0 до 59");
        }
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Ошибка: секунды должны быть от 0 до 59");
        }

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void addSeconds(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Ошибка: нельзя добавлять отрицательные секунды");
        }

        int totalSeconds = toTotalSeconds() + seconds;
        totalSeconds %= 24 * 3600;

        hours = totalSeconds / 3600;
        minutes = (totalSeconds % 3600) / 60;
        this.seconds = totalSeconds % 60;
    }

    public void addMinutes(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Ошибка: нельзя добавлять отрицательные минуты");
        }
        addSeconds(minutes * 60);
    }

    public void addHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Ошибка: нельзя добавлять отрицательные часы");
        }
        addSeconds(hours * 3600);
    }

    public int differenceInSeconds(Time other) {
        if (other == null) {
            throw new IllegalArgumentException("Ошибка: объект времени не может быть null");
        }
        return Math.abs(this.toTotalSeconds() - other.toTotalSeconds());
    }

    private int toTotalSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public void print24h() {
        System.out.printf("%02d:%02d:%02d%n", hours, minutes, seconds);
    }

    public void print12h() {
        int displayHours = hours % 12;
        if (displayHours == 0) {
            displayHours = 12;
        }

        String period = hours < 12 ? "AM" : "PM";
        System.out.printf("%02d:%02d:%02d %s%n", displayHours, minutes, seconds, period);
    }
}

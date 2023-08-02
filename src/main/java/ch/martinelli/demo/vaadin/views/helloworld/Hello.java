package ch.martinelli.demo.vaadin.views.helloworld;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Hello {

    private LocalDate date;
    private LocalDateTime dateTime;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "date=" + date +
                ", dateTime=" + dateTime +
                '}';
    }

}

package it.exercise.classes;


import it.exercise.enums.EventType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private long id;

    @Column (name = "titolo")
    private String title;

    @Column (name = "data_evento")
    private LocalDate date;

    @Column (name = "descrizione")
    private String description;

    @Column(name="tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name="num_max_partecipanti")
    private int maxNum;

    public Evento(){}

    public Evento(String title, LocalDate date, String description, EventType eventType, int maxNum) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.eventType = eventType;
        this.maxNum = maxNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxNum=" + maxNum +
                '}';
    }
}

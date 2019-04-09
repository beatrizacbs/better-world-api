package br.com.betterworld.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "event")
public class Event {

    @Id
    private ObjectId id;
    private String title;
    private String description;
    private String address;
    private Date date;
    private List<ObjectId> participants;

    public Event() {
    }

    public Event(String title, String description, String address, Date date, List<ObjectId> participants) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.date = date;
        this.participants = participants;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ObjectId> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ObjectId> participants) {
        this.participants = participants;
    }
}

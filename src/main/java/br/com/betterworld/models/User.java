package br.com.betterworld.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "user")
public class User {

    @Id
    private ObjectId id;
    private String email;
    private String password;
    private String name;
    private Date birthDate;
    private List<Event> hostedEvents;
    private List<Event> participantEvents;
    private List<ObjectId> connections;

    public User() {
    }

    public User(String email, String password, String name, Date birthDate, List<Event> hostedEvents, List<Event> participantEvents, List<ObjectId> connections) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.hostedEvents = hostedEvents;
        this.participantEvents = participantEvents;
        this.connections = connections;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Event> getHostedEvents() {
        return hostedEvents;
    }

    public void setHostedEvents(List<Event> hostedEvents) {
        this.hostedEvents = hostedEvents;
    }

    public List<Event> getParticipantEvents() {
        return participantEvents;
    }

    public void setParticipantEvents(List<Event> participantEvents) {
        this.participantEvents = participantEvents;
    }

    public List<ObjectId> getConnections() {
        return connections;
    }

    public void setConnections(List<ObjectId> connections) {
        this.connections = connections;
    }
}

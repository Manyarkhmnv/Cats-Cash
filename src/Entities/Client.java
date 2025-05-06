package Entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String firstName;
    private String lastName;
    private List<String> messages;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.messages = new ArrayList<>();
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void notifyClient(String message) {
        messages.add(message);
    }
    public void printMessages() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

}


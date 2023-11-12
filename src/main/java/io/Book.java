package io;

import java.io.Serializable;

// Serializable is a marker interface
public class Book implements Serializable {
    // TODO: what serialVersionUID is for?
    private static final long serialVersionUID = 1L;  // to provide back-ward compatibility

    private String writer;
    private String topic;
    private int numberOfCopiesSold;

    public Book(String writer, String topic, int numberOfCopiesSold) {
        this.writer = writer;
        this.topic = topic;
        this.numberOfCopiesSold = numberOfCopiesSold;
    }

    // getters & setters

    @Override
    public String toString() {
        return "Book{" +
                "author='" + writer + '\'' +
                ", title='" + topic + '\'' +
                ", numberOfCopiesSold=" + numberOfCopiesSold +
                '}';
    }
}

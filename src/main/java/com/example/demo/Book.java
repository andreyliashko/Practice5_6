package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {
    private String name;
    private String ibsn;
    private String author;
    Book(){}
    Book(String name, String ibsn, String author){
        this.author=author;
        this.name=name;
        this.ibsn=ibsn;
    }
    public String getName(){
        return this.name;
    }
    public String getIbsn(){
        return this.ibsn;
    }
    public String getAuthor(){
        return this.author;
    }
    public String toString(){
        return this.name+"; "+this.ibsn+"; "+ this.author+"\n";
    }
}

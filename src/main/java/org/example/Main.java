package org.example;

import org.example.entity.StringSet;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> results = StringSet.findUniqueWords();
        System.out.println("Unique words: " + results);

    }
}
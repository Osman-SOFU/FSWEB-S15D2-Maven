package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks = new HashSet<>();
    private Set<Task> bobsTasks = new HashSet<>();
    private Set<Task> carolsTasks = new HashSet<>();
    private Set<Task> unassignedTasks = new HashSet<>();

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String personName) {
        switch (personName.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            default:
                return unassignedTasks;
        }
    }

    public Set<Task> getUnion(Set<Task> taskSet, Set<Task> taskSet2) {
        // Orijinal setleri değiştirmeden birleştir
        Set<Task> unionSet = new HashSet<>(taskSet);
        unionSet.addAll(taskSet2);
        return unionSet;
    }

    public Set<Task> getIntersection(Set<Task> taskSet, Set<Task> taskSet2) {
        // Kopya oluştur ve kesişimi bul
        Set<Task> intersectionSet = new HashSet<>(taskSet);
        intersectionSet.retainAll(taskSet2);
        return intersectionSet;
    }

    public Set<Task> getDifferences(Set<Task> taskSet, Set<Task> taskSet2) {
        // Kopya oluştur ve farkı bul
        Set<Task> differenceSet = new HashSet<>(taskSet);
        differenceSet.removeAll(taskSet2);
        return differenceSet;
    }
}

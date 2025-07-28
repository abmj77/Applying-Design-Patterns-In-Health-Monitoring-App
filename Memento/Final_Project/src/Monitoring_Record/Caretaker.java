package Monitoring_Record;

import java.util.ArrayList;

public class Caretaker {
    private final ArrayList<Memento> savedArticles = new ArrayList<>();
    private int currentIndex = -1;

    public void addMemento(Memento m) {
        while (savedArticles.size() > currentIndex + 1) {
            savedArticles.remove(savedArticles.size() - 1);
        }
        savedArticles.add(m);
        currentIndex++;
    }
    public Memento getMemento(int index) {
        if (index >= 0 && index < savedArticles.size()) {
            return savedArticles.get(index);
        }
        return null;
    }
    public boolean canUndo() {
        return currentIndex > 0;
    }
    public boolean canRedo() {
        return currentIndex < savedArticles.size() - 1;
    }
    public Memento undo() {
        if (canUndo()) {
            currentIndex--;
            return savedArticles.get(currentIndex);
        }
        return null;
    }
    public Memento redo() {
        if (canRedo()) {
            currentIndex++;
            return savedArticles.get(currentIndex);
        }
        return null;
    }
}
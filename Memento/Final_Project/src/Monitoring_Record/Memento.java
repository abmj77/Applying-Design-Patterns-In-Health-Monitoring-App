package Monitoring_Record;

public class Memento {
    private final String article;

    public Memento(String articleSave) {
        this.article = articleSave;
    }

    public String getSavedArticle() {
        return article;
    }
}
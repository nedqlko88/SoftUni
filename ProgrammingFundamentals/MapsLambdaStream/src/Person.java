public class Person {
    private String language;
    private int points;
    private boolean isValid;
    private int countsOfSubmissions;

    public Person(String language, int points, boolean isValid, int countsOfSubmissions) {
        this.language = language;
        this.points = points;
        this.isValid = isValid;
        this.countsOfSubmissions = countsOfSubmissions;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getCountsOfSubmissions() {
        return this.countsOfSubmissions;
    }

    public void setCountsOfSubmissions(int countsOfSubmissions) {
        this.countsOfSubmissions = countsOfSubmissions;
    }
}

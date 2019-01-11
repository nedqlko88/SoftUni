package softuni.bandregister.bindingModels;

public class BandBindingModel {

    private String name;
    private String members;
    private Double honorarium;
    private String genre;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return this.members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public Double getHonorarium() {
        return this.honorarium;
    }

    public void setHonorarium(Double honorarium) {
        this.honorarium = honorarium;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

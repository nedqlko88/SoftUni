package ned.fdmc.data.repos;

import ned.fdmc.data.models.Cat;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CatRepo {
    private Set<Cat> cats;

    public CatRepo() {
        this.cats = new HashSet<>();
    }
    public Cat getCatByName(String catName) {
        return this.cats.stream()
                .filter(x -> x.getName().equals(catName))
                .findFirst()
                .orElse(null);
    }

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }

    public Set<Cat> getAllCats() {
        return Collections.unmodifiableSet(this.cats);
    }



}

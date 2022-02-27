package by.training.task1.builder;

import by.training.task1.entity.Gem;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGemBuilder {
    protected Set<Gem> gemSet;

    public AbstractGemBuilder() {
        gemSet = new HashSet<>();
    }

    public Set<Gem> getGemSet() {
        return gemSet;
    }

    public abstract void buildGemSet(String fullFilePath);
}

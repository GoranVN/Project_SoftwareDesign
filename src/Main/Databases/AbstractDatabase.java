package Databases;

import java.util.ArrayList;

public abstract class AbstractDatabase {
    public AbstractDatabase(){}

    public abstract ArrayList<?> getEntries();

    public abstract void deleteAll();
}

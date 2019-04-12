package fr.ustephan.codekata.backtocheckout;

public class Item {

    private final String id;
    private final String name;

    Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

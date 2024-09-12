package tp.model;

public class Category {

    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("unused")
    private int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    private void setName(String name) {
        this.name = name;
    }


}

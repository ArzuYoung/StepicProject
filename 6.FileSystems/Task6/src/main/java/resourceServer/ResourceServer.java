package resourceServer;

public class ResourceServer implements ResourceServerI{
    private String name;
    private int age;

    public ResourceServer(String name, int age) {
        this.name = "";
        this.age = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int newAge) {
        this.age = newAge;
    }
}

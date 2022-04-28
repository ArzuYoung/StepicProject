package resources;

import javax.management.DynamicMBean;

@SuppressWarnings("UnusedDeclaration")
public class TestResource implements TestResourceI {
    private String name;
    private int age;

    public TestResource(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestResource() {
        this.name = "";
        this.age = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}

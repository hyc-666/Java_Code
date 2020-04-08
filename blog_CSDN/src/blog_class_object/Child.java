package blog_class_object;

public class Child extends Person {
    private int age;

    public Child(String name, String sex, int age) {
        super(name, sex);
        this.age = age;
    }

    public Child(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name = " + super.getName() + ",sex = " + super.getSex() +
                ",weight = " + super.getWeight() + ",height = " + super.getHeight() +
                ",age = " + age;
    }

    public static void main(String[] args) {
        Person tom = new Child("Tom","boy",18);

    }
}

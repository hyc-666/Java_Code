package blog_class_object;

public class Person {
    private String name;//姓名
    private String sex;//性别
    private int height;//身高
    private int weight;//体重

    public Person() {

    }

    public Person(String name, String sex, int height, int weight) {
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

}

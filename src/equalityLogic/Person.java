package iteratorsAndComparators.equalityLogic;

public class Person implements Comparable<Person>{

    private String name;

    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }

        if (!(obj instanceof Person)){
            return false;
        }

        Person person = (Person) obj;

        return this.getAge() == person.getAge() && this.getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.getAge();

        return result;
    }

    @Override
    public int compareTo(Person person) {
        if (this.getAge() - person.getAge() == 0 && this.getName().compareTo(person.getName()) == 0){
            return 0;
        } else if (this.getName().compareTo(person.getName()) == 0){
            return this.getAge() - person.getAge();
        }

        return this.getName().compareTo(person.getName());
    }
}

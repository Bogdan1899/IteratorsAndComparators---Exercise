package iteratorsAndComparators.petClinic.models;

import iteratorsAndComparators.petClinic.models.interfaces.Pet;

public class PetImpl implements Pet {

    private String name;

    private int age;

    private String kind;

    public PetImpl(String name, int age, String kind) {
        this.setName(name);
        this.setAge(age);
        this.setKind(kind);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.length() < 1 || name.length() > 50){
            throw new IllegalArgumentException("The length should be between 1-50");
        }

        this.name = name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < 1 || age > 100){
            throw new IllegalArgumentException("The age should be between 1-100");
        }

        this.age = age;
    }

    @Override
    public String getKind() {
        return this.kind;
    }

    private void setKind(String kind) {
        if (kind.length() < 1 || kind.length() > 50){
            throw new IllegalArgumentException("The length should be between 1-50");
        }

        this.kind = kind;
    }

    @Override
    public String toString() {

        return String.format("%s %d %s", this.getName(), this.getAge(), this.getKind());
    }
}

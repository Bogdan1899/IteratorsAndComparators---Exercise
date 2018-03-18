package iteratorsAndComparators.petClinic.models;

import iteratorsAndComparators.petClinic.models.interfaces.Clinic;
import iteratorsAndComparators.petClinic.models.interfaces.Pet;

public class ClinicImpl implements Clinic {

    private String name;

    private Pet[] rooms;

    private int currentAvailableRoom;

    private int counter;

    private int indexToTheLeft;

    private int indexToTheRight;

    private boolean isGoingLeft;

    public ClinicImpl(String name, int numberOfRooms) {
        this.setName(name);
        this.setRooms(numberOfRooms);
        this.currentAvailableRoom = numberOfRooms / 2;
        this.indexToTheLeft = this.currentAvailableRoom;
        this.indexToTheRight = this.currentAvailableRoom;
        this.counter = 1;
        this.isGoingLeft = true;
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

    private void setRooms(int numberOfRooms) {
        if ((numberOfRooms < 1 || numberOfRooms > 101) || numberOfRooms % 2 == 0){
            throw new IllegalArgumentException("Wrong rooms number");
        }

        this.rooms = new Pet[numberOfRooms];
    }

    @Override
    public boolean addPet(Pet pet) {

        while (this.currentAvailableRoom >= 0
                && this.currentAvailableRoom < this.rooms.length
                && this.rooms[this.currentAvailableRoom] != null){
            if (isGoingLeft){
                this.currentAvailableRoom = this.indexToTheLeft - counter;
                isGoingLeft = false;
            } else {
                this.currentAvailableRoom = this.indexToTheRight + counter;
                isGoingLeft = true;
                this.counter++;
            }
        }

        if (this.currentAvailableRoom >= 0
                && this.currentAvailableRoom < this.rooms.length
                && this.rooms[this.currentAvailableRoom] == null){
            this.rooms[this.currentAvailableRoom] = pet;
            return true;
        }

        return false;
    }

    @Override
    public boolean release() {
        int indexToRelease = this.rooms.length / 2;

        for (int i = indexToRelease; i < this.rooms.length; i++) {
            if (this.rooms[i] != null){
                this.rooms[i] = null;
                return true;
            }
        }

        for (int i = 0; i < indexToRelease; i++) {
            if (this.rooms[i] != null){
                this.rooms[i] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hasEmptyRooms() {
        for (Pet room : rooms) {
            if (room == null){
                return true;
            }
        }

        return false;
    }

    @Override
    public String print(int room) {
        Pet pet = this.rooms[room - 1];

        return pet.toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (Pet room : rooms) {
            if (room != null){
                output.append(room.toString());
            } else {
                output.append("Room empty");
            }

            output.append(System.lineSeparator());
        }

        return output.toString();
    }
}

package iteratorsAndComparators.petClinic.models.interfaces;

public interface Clinic {

    String getName();

    boolean addPet(Pet pet);

    boolean release();

    boolean hasEmptyRooms();

    String print(int room);
}

package iteratorsAndComparators.petClinic;

import iteratorsAndComparators.petClinic.models.interfaces.Clinic;
import iteratorsAndComparators.petClinic.models.interfaces.Pet;
import java.util.List;

public interface Database {

    List<Pet> getPets();

    List<Clinic> getClinics();

    void addPet(Pet pet);

    void addClinic(Clinic clinic);

    boolean addPetToClinic(String petName, String clinicName);

    Pet getPet(String name);

    Clinic getClinic(String name);
}

package iteratorsAndComparators.petClinic.factories.interfaces;

import iteratorsAndComparators.petClinic.models.interfaces.Pet;

public interface PetFactory {

    Pet createPet(String name, int age, String kind);
}

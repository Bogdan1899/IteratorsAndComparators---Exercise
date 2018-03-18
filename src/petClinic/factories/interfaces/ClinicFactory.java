package iteratorsAndComparators.petClinic.factories.interfaces;

import iteratorsAndComparators.petClinic.models.interfaces.Clinic;

public interface ClinicFactory {

    Clinic createClinic(String name, int rooms);
}

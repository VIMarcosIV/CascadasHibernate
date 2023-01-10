package org.iesch.ad;

import org.iesch.ad.dao.IdCardDAO;
import org.iesch.ad.dao.PersonDAO;
import org.iesch.ad.modelo.IdCard;
import org.iesch.ad.modelo.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        IdCardDAO idCardDAO = new IdCardDAO();

        Person person = new Person();
        IdCard idCard = new IdCard();
        person.setDni("18463452L");
        person.setName("Pedro");
        person.setLastname("Juancho");
        person.setTarjeta(null);

        idCard.setActivo(true);
        idCard.setTitulo("Titulo");
        idCard.setFechaCaducidad(LocalDate.now());

        idCard.setPerson(person);
        person.setTarjeta(idCard);

//        personDAO.guarda(person);

        personDAO.borra(person);

    }
}

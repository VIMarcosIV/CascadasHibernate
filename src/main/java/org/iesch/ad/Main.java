package org.iesch.ad;

import org.iesch.ad.dao.AsociacionDAO;
import org.iesch.ad.dao.ClubDAO;
import org.iesch.ad.dao.IdCardDAO;
import org.iesch.ad.dao.PersonDAO;
import org.iesch.ad.modelo.Asociacion;
import org.iesch.ad.modelo.Club;
import org.iesch.ad.modelo.IdCard;
import org.iesch.ad.modelo.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        PersonDAO personDAO = new PersonDAO();
//        IdCardDAO idCardDAO = new IdCardDAO();
//
//        Person person = new Person();
//        IdCard idCard = new IdCard();
//        person.setDni("18463452L");
//        person.setName("Pedro");
//        person.setLastname("Juancho");
//        person.setTarjeta(null);
//
//        idCard.setActivo(true);
//        idCard.setTitulo("Titulo");
//        idCard.setFechaCaducidad(LocalDate.now());
//
//        idCard.setPerson(person);
//        person.setTarjeta(idCard);
//
////        personDAO.guarda(person);
//
//        personDAO.borra(person);

        AsociacionDAO asociacionDAO = new AsociacionDAO();
        ClubDAO clubDAO = new ClubDAO();

        Asociacion asociacion = new Asociacion();
        asociacion.setNombre("Aragonesasdasdasdasdasa");

        Club club1 = new Club();
        club1.setNombre("SAdiasjdaAliaga");
        club1.setAsociacion(asociacion);

        Club club2 = new Club();
        club2.setNombre("Pasdasdasdasdepito");
        club2.setAsociacion(asociacion);
//
        asociacion.addClub(club1);
        asociacion.addClub(club2);

        asociacionDAO.guarda(asociacion);

        clubDAO.borra(club1);
    }
}

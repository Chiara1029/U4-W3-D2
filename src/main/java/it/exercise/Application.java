package it.exercise;

import it.exercise.classes.Evento;
import it.exercise.dao.EventoDAO;
import it.exercise.enums.EventType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args) {
        System.out.println("--- Esercizio U4-W3-D2 ---");

        EntityManager em = emf.createEntityManager();
        EventoDAO evDao = new EventoDAO(em);

        Evento galleriaBorghese = new Evento("Mostra Galleria Borghese", "2024-12-31", "Mostra Galleria Borghese", EventType.PUBBLICO, 400);
        Evento pompei = new Evento("Parco Archeologico di Pompei", "2024-01-23", "Parco Archeologico di Pompei", EventType.PUBBLICO, 1000);
        Evento vanGoghMi = new Evento("Van Gogh", "20204-01-28", "Mostra presso AI Mudec di Milano", EventType.PUBBLICO, 300);
        Evento vgExp = new Evento("Open - Van Gogh Experience", "2024-03-31", "Mostra multimediale a Roma", EventType.PRIVATO, 50);

        evDao.saveEvent(galleriaBorghese);
        evDao.saveEvent(pompei);
        evDao.saveEvent(vanGoghMi);
        evDao.saveEvent(vgExp);

        long id = 2;
        Evento searchEv = evDao.getEventById(id);
        if(searchEv != null){
            System.out.println("Evento trovato: " + searchEv.getTitle());
        } else System.out.println("Evento non trovato");

        evDao.deleteById(1);


        em.close();
        emf.close();
    }
}

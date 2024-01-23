package it.exercise.dao;

import it.exercise.classes.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em){
        this.em = em;
    }

    public void saveEvent(Evento evento){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("L'evento '" + evento.getTitle() + "' è stato aggiunto alla lista.");
    }

    public Evento getEventById(long id){
        return em.find(Evento.class, id);
    }

    public void deleteById(long id){
        Evento foundEvent = this.getEventById(id);
        if(foundEvent != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundEvent);
            transaction.commit();
            System.out.println("L'evento " + foundEvent.getTitle() + " è stato eliminato.");
        } else System.out.println("Non ci sono eventi con ID: " + id);
    }
}

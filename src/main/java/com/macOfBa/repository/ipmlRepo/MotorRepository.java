package com.macOfBa.repository.ipmlRepo;

import com.macOfBa.model.Motor;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class MotorRepository implements IMotorRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Motor> findAll() {
        TypedQuery<Motor> query = em.createQuery("select c from Motor c", Motor.class);
        return query.getResultList();
    }

    @Override
    public Motor findById(int id) {
       TypedQuery<Motor> query = em.createQuery("select c from Motor c where c.id=:id", Motor.class);
       query.setParameter("id", id);
       try {
           return query.getSingleResult();
       }catch (NoResultException e){
           return null;
       }
    }

    @Override
    public void save(Motor motor) {
        if (motor.getId() != 0) {
            em.merge(motor);
        }else {
            em.persist(motor);
        }
    }

    @Override
    public void remove(int id) {
        Motor motor = findById(id);
        if (motor != null) {
            em.remove(motor);
        }
    }
}

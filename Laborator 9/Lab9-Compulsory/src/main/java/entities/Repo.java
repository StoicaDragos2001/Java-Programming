package entities;

import manager.Manager;

import javax.persistence.EntityManager;

public abstract class Repo<T> {
    static EntityManager manager;

    public Repo() {
        Manager managerInstance = Manager.getInstance();
        manager = managerInstance.getManager();
    }

    public void create(T entity) {
        manager.persist(entity);
        manager.getTransaction().commit();
    }
}
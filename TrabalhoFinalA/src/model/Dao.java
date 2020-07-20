/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author aluno
 */
public class Dao {
    EntityManager em = Persistence.createEntityManagerFactory("TrabalhoFinalAPU").createEntityManager();
    
    public boolean inserir(Object object){
        try{
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public void inserirDesconto(Desconto desconto){
        try{
            em.getTransaction().begin();
            em.persist(desconto);
            em.getTransaction().commit();
        } catch (PersistenceException e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    
    public boolean excluir(Object object){
        try{
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e){
            System.out.println(e.toString());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean editar(Object object){
        try{
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public List<Cliente> listarClientes(){
        return em.createQuery("Select c from Cliente c").getResultList();
    }
    
    public List<Comanda> listarComandas(){
        return em.createQuery("Select c from Comanda c").getResultList();
    }
    
    public List<Item> listarItens(){
        return em.createQuery("Select i from Item i").getResultList();
    }
    
    public List<Mesa> listarMesas(){
        return em.createQuery("Select m from Mesa m").getResultList();
    }
    
    public List<Reserva> listarReservas(){
        return em.createQuery("Select r from Reserva r").getResultList();
    }
    
    public List<ItemComanda> listarItemComanda(){
        return em.createQuery("Select i from ItemComanda i group by i.id").getResultList();
    }
    
    public int getIdComanda(int id){
        return (int) em.createQuery("Select ic.id from ItemComanda ic where ic.comanda=:id").getSingleResult();
    }
    
    public Cliente selecionarCliente(int id){
        return em.find(Cliente.class, id);
    }
    
    public Comanda selecionarComanda(int id){
        return em.find(Comanda.class, id);
    }
    
    public Item selecionarItem(int id){
        return em.find(Item.class, id);
    }
    
    public Mesa selecionarMesa(int id){
        return em.find(Mesa.class, id);
    }
    
    public Reserva selecionarReserva(int id){
        return em.find(Reserva.class, id);
    }
    
    public Desconto selecionarDesconto(){
        return em.find(Desconto.class, 1);
    }
    
    public ItemComanda selecionarItemComanda(int id){
        return em.find(ItemComanda.class, id);
    }
}

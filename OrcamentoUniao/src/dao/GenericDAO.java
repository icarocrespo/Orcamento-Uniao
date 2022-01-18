package dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author icaro
 */
public abstract class GenericDAO<T, I extends Serializable> {

    protected EntityManager em;

    private Class<T> persistedClass;

    protected GenericDAO() {
        EntityManagerFactory emf;
        try {
            emf = Conexao.getConexao();
            em = emf.createEntityManager();
        } catch (Exception ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger("Não foi possível realizar a conexão com a unidade de persistência. Verifique a conexão");
        }
    }

    protected GenericDAO(Class<T> persistedClass) {
        this();
        this.persistedClass = persistedClass;
    }

    public Boolean insert(T obj) {
        Boolean retorno;
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            retorno = true;
        } catch (RuntimeException e) {
            em.getTransaction().rollback();

            retorno = false;
            throw e;
        } finally {
            //em.close();           
        }
        return retorno;
    }

    public Boolean update(T obj) {
        Boolean retorno;
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            retorno = true;
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            retorno = false;
            throw e;
        } finally {
            // em.close();
        }
        return retorno;
    }

    public Boolean delete(T obj) {
        Boolean retorno;
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            retorno = true;
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            retorno = false;
        } finally {
            //em.close();
        }
        return retorno;
    }

    public T searchByPK(I chaveprimaria) {
        return em.find(persistedClass, chaveprimaria);
    }

    public List<T> list() {
        return em.createNamedQuery(persistedClass.getSimpleName() + ".findAll").getResultList();
    }
}
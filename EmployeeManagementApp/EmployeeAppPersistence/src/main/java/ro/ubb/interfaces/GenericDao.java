package ro.ubb.interfaces;

import java.sql.SQLException;

public interface GenericDao {
    /**
     *
     * @param id id must be not null
     * @return null - if the given entity doesn't exists otherwise returns the entity
     */
    Object find(int id) throws ClassNotFoundException, SQLException;

    /**
     * @param entity entity must be not null
     * @return returns the entity if the given entity is saved otherwise null  (id already exists)
     */
    Object save(Object entity) throws ClassNotFoundException, SQLException;

    /**
     * removes the object with the specified id
     *
     * @param id id must be not null
     * @return the removed object or null if there is no entity with the given id
     */
    Object delete(int id) throws SQLException, ClassNotFoundException;

    /**
     * @param entity entity must not be null
     * @return null - if the entity doesn't exists, otherwise returns the entity - (e.g id does not exist).
     */
    Object update(Object entity) throws SQLException, ClassNotFoundException;
}

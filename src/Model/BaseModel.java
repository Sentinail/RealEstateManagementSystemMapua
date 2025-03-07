/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Sentinail
 */

public abstract class BaseModel<T> {
    public abstract T create(T entity) throws SQLException;
    public abstract Optional<T> read(int id) throws SQLException;
    public abstract List<T> readAll() throws SQLException;
    public abstract T update(int id, T entity) throws SQLException;
    public abstract boolean delete(int id) throws SQLException;
}


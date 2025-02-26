/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Sentinail
 */

public abstract class BaseModel<T> {
    public abstract T create(T entity);
    public abstract Optional<T> read(int id);
    public abstract List<T> readAll();
    public abstract T update(int id, T entity);
    public abstract boolean delete(int id);
}


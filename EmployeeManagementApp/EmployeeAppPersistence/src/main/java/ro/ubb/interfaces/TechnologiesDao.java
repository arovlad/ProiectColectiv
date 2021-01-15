package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;

import java.util.List;

public interface TechnologiesDao {
    List<String> findAll() throws DbException;
}

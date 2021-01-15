package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;

import java.util.List;

public interface TechnologiesService {

        List<String> findAll() throws DbException;


}

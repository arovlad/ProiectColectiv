package ro.ubb.services;

import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.TechnologiesDaoImpl;
import ro.ubb.interfaces.TechnologiesDao;
import ro.ubb.interfaces.TechnologiesService;

import java.util.List;

public class TechnologiesServiceImpl implements TechnologiesService {

    @Override
    public List<String> findAll() throws DbException {
        TechnologiesDao technologiesDao=new TechnologiesDaoImpl();

        return (technologiesDao).findAll();
    }
}

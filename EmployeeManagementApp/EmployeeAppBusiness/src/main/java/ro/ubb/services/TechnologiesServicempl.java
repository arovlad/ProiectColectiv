package ro.ubb.services;

import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.TechnologiesDaoImpl;
import ro.ubb.interfaces.TechnologiesDao;
import ro.ubb.interfaces.TechnologiesService;

import java.util.List;

public class TechnologiesServiceImpl implements TechnologiesService {

    @Override
    public List<String> getAllTechnologies() throws DbException {
        TechnologiesDao TechnologiesDao=new TechnologiesDaoImpl();

        return TechnologiesDao.getAllTechnologiesNames();
    }
}

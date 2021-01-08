package ro.ubb.services;

import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.IndustryDaoImpl;
import ro.ubb.interfaces.IndustryDao;
import ro.ubb.interfaces.IndustryService;

import java.util.List;

public class IndustryServiceImpl implements IndustryService {

    @Override
    public List<String> getAllIndustryNames() throws DbException {
        IndustryDao industryDao=new IndustryDaoImpl();

        return industryDao.getAllIndustryNames();
    }
}

package ro.ubb.services;

import ro.ubb.dtos.RegionDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.RegionDaoImpl;
import ro.ubb.interfaces.RegionDao;
import ro.ubb.interfaces.RegionService;
import ro.ubb.mappers.RegionDtoMapper;
import ro.ubb.models.Region;

public class RegionServiceImpl implements RegionService {
    private static final int Deleted = 1;
    private static final int Error = -1;

    @Override
    public RegionDto save(Object entity) throws DbException {
        return RegionDtoMapper.mapRegionToRegionDto(new RegionDaoImpl().save(entity));
    }

    @Override
    public int delete(int id) throws DbException {
        Region r = new RegionDaoImpl().delete(id);
        if(r != null)
            return Deleted;
        else
            return Error;
    }
}

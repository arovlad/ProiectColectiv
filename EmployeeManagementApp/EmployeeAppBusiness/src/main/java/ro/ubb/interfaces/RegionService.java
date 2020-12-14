package ro.ubb.interfaces;

import ro.ubb.dtos.RegionDto;
import ro.ubb.exceptions.DbException;

public interface RegionService {
    RegionDto save(Object entity) throws DbException;

    int delete(int id) throws DbException;
}

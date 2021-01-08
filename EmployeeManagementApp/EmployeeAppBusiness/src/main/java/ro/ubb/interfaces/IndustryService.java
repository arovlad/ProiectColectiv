package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;

import java.util.List;

public interface IndustryService {

    List<String> getAllIndustryNames() throws DbException;
}

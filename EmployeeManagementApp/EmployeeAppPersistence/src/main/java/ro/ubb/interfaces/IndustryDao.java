package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;

import java.util.List;

public interface IndustryDao {

    List<String> getAllIndustryNames() throws DbException;
}

package agence.dao;

import java.util.List;

import agence.model.Escale;

public interface EscaleDao extends Dao<Escale, Integer>
{
	List<Escale> findAll();
	Escale findById(Integer id);
	
}

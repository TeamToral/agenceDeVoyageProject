package agence.dao;

import java.util.List;

import agence.model.Vol;

public interface VolDao extends Dao<Vol, Integer> 
{
	@Override
	List<Vol> findAll();
	@Override
	Vol findById(Integer id);
}

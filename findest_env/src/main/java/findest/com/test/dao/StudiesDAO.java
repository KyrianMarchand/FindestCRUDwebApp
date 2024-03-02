package findest.com.test.dao;

import java.util.List;

import findest.com.test.entity.Studies;

public interface StudiesDAO {

	public void create(Studies stud);

	public void update(Studies stud);

	public Boolean remove(Studies p);

	public List<Studies> findAll(String tri, String ordre);

	public Studies findById(Integer id);

}
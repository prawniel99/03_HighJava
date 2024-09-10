package a.dao;

import java.util.List;

import a.vo.Avo;

public class ADaoImpl implements IADao {

	private static ADaoImpl dao;
	
	private ADaoImpl() {}
	
	public static ADaoImpl getInstance() {
		if(dao == null) dao = new ADaoImpl();
		
		return dao;
	}

	@Override
	public List<Avo> memberList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

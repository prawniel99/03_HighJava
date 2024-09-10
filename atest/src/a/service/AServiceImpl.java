package a.service;

import a.dao.ADaoImpl;
import a.dao.IADao;

public class AServiceImpl implements IAService {

	private static AServiceImpl service;
	
	private IADao dao;
	
	private AServiceImpl() {
		dao = ADaoImpl.getInstance();
	}
	
	public static AServiceImpl getInstance() {
		if(service == null) service = new AServiceImpl();
		
		return service;
	}
	
}

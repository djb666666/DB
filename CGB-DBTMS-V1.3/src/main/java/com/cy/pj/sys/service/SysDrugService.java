package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

public interface SysDrugService {
	List<Map<String, Object>> findObjects();
	
	int deleteObjects(Integer... ids);
}

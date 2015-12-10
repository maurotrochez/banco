package co.edu.uniajc.utils;

import java.math.BigDecimal;
import java.util.Date;

public class Validate implements IValidate{
	
	@Override
	public boolean validateString(String text) throws Exception {
		if(text==null || text.trim().equals(""))
			return true;
		return false;
	}
	
	@Override
	public boolean validateId(Long id) throws Exception{
		if(id == 0 || id == null)
			return true;
		return false;
	}
	
	@Override
	public boolean validateObject(Object obj) throws Exception {
		if(obj==null)
			return true;
		return false;
	}
	
	@Override
	public boolean validateNumeric(BigDecimal num) throws Exception {
		if(num==null)
			return true;
		return false;
	}
	
	@Override
	public boolean validateDate(Date date) throws Exception {
		if(date == null)
			return true;
		return false;
	}
}


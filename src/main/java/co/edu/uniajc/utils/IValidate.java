package co.edu.uniajc.utils;

public interface IValidate {
	
	public boolean validateString(String text) throws Exception;
	public boolean validateId(Long id) throws Exception;
	public boolean validateObject(Object obj) throws Exception;
}

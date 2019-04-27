package br.edu.puc.util;

public enum ConstantsEnum {
	
	AUTHENTICATION_HEADER("x-access-token");

	private ConstantsEnum(String value) {
		this.value = value;
	}
	
	private String value;
	
	public String getValue(){
		return this.value;
	}
}

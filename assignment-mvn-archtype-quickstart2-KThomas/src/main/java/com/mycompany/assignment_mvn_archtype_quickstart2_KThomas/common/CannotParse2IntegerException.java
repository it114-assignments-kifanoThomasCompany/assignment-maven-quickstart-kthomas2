/**
 * 
 */
package com.mycompany.assignment_mvn_archtype_quickstart2_KThomas.common;

/**
 * @author Ken
 *
 */
public class CannotParse2IntegerException extends Exception {

	private static final long serialVersionUID = 1L;

	private String str2parse;
	
	public CannotParse2IntegerException(String _str2parse) {
		str2parse = _str2parse;
	}

	public String getStr2parse() {
		return str2parse;
	}
}

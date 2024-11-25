package com.workday.custom.int093.ssk117.parsers;

import java.util.Iterator;

import com.workday.custom.int093.ssk117.mediations.EnhancedBufferedReader;

public interface IParser extends Iterator<String[]> {

	public void setReader(EnhancedBufferedReader reader);
	
	public String[] getHeaders(boolean isFirstRowHeader) throws Exception;
}

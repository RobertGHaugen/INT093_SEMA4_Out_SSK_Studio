package com.workday.custom.int093.ssk117.writers;

import com.capeclear.capeconnect.attachments.io.FileBackedManagedData;

public interface ITransformer {
	
	public String getContentType();
	
	public void setOutputTarget(FileBackedManagedData fbmd) throws Exception;
	
	public void setFieldNames(String[] fieldNames);
	
	public void transformRecordToOutputStream(String[] parsedRecordData) throws Exception;
	
	public void batch() throws Exception;

}

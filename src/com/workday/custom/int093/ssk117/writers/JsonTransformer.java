package com.workday.custom.int093.ssk117.writers;

import com.capeclear.capeconnect.attachments.io.FileBackedManagedData;

public class JsonTransformer implements ITransformer {
	private final String contentType = "application/json";

	@Override
	public String getContentType() {
		return contentType;
	}

	@Override
	public void setOutputTarget(FileBackedManagedData fbmd) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void transformRecordToOutputStream(String[] parsedRecordData) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void batch() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFieldNames(String[] fieldNames) {
		// TODO Auto-generated method stub
		
	}

}

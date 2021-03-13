package io.namoosori.java.fileserver.server.handler;

import java.util.ArrayList;
import java.util.List;

import io.namoosori.java.fileserver.server.repo.FileStore;
import io.namoosori.java.fileserver.util.RequestMessage;
import io.namoosori.java.fileserver.util.ResponseMessage;

public class FileFindHandler implements FileHandler {
	//
	public FileFindHandler() {
		//
	}

	@Override
	public ResponseMessage handle(RequestMessage request) {
		//
		// TODO Implement method
		FileStore fileStore = getFileStore();
		String fileName = request.getRemark();	
		char[] contents = fileStore.readFile(fileName);		
		
		ResponseMessage response = null;		
		response = new ResponseMessage(request.getServiceName(), String.valueOf(contents));
		
		return response;
	}

	public FileStore getFileStore() {
		//
		return FileStore.newInstance();
	}
}

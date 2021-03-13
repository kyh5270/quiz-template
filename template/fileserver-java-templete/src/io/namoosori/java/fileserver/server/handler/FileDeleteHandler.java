package io.namoosori.java.fileserver.server.handler;


import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

import io.namoosori.java.fileserver.server.repo.FileStore;
import io.namoosori.java.fileserver.util.RequestMessage;
import io.namoosori.java.fileserver.util.ResponseMessage;

public class FileDeleteHandler implements FileHandler {
	//
	public FileDeleteHandler() {
		//

	}

	@Override
	public ResponseMessage handle(RequestMessage request) {
		//
		// TODO Implement method
		FileStore fileStore = getFileStore();
		String fileName = request.getRemark();
		
		ResponseMessage response = null;
		fileStore.deleteFile(fileName);
		response = new ResponseMessage(request.getServiceName(), fileName);
		
		return response;
	}

	public FileStore getFileStore() {
		//
		return FileStore.newInstance();
	}
}

package io.namoosori.java.fileserver.server.handler;

import java.util.ArrayList;
import java.util.List;

import io.namoosori.java.fileserver.server.repo.FileStore;
import io.namoosori.java.fileserver.util.RequestMessage;
import io.namoosori.java.fileserver.util.ResponseMessage;

public class FileListHandler implements FileHandler {
	//
	public FileListHandler() {
		//
	}

	@Override
	public ResponseMessage handle(RequestMessage request) {
		//
		// TODO Implement method
		FileStore fileStore = getFileStore();
		List<String> fileList = new ArrayList<>();
			
		ResponseMessage response = null;
		fileList = fileStore.listFiles();
		response = new ResponseMessage(request.getServiceName(), fileList.toString());
		
		return response;
	}

	public FileStore getFileStore() {
		//
		return FileStore.newInstance();
	}
}

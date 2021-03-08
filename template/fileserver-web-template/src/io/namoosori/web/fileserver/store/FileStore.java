package io.namoosori.web.fileserver.store;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

import org.springframework.stereotype.Repository;

import io.namoosori.web.fileserver.context.FileContext;
import io.namoosori.web.fileserver.util.FileUtil;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FileStore {
	//
	private final FileUtil fileUtil;
	
	public byte[] readFile(String fileName) {
		//
		// TODO Implements method		
		return this.fileUtil.read(this.fileUtil.findFile(FileContext.SERVER_REPOSITORY_FOLDER, fileName));
	}

	public void deleteFile(String fileName) {
		//
		// TODO Implements method
		this.fileUtil.deleteFile(FileContext.SERVER_REPOSITORY_FOLDER, fileName);
		
	}

	public void writeFile(String fileName, byte[] contents) throws FileAlreadyExistsException {
		//
		//
		// TODO Implements method
		this.fileUtil.createFile(FileContext.SERVER_REPOSITORY_FOLDER, fileName);
	}

	public List<String> listFiles() {
		//
		//
		// TODO Implements method
		return this.fileUtil.findFileList(FileContext.SERVER_REPOSITORY_FOLDER);
	}

}

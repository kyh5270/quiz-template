package io.namoosori.web.fileserver.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.namoosori.web.fileserver.store.FileStore;
import io.namoosori.web.fileserver.util.FileUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceLogic implements FileService {
    //
	// TODO Dependency Injection
	//  1. FileStore
	//  2. FileUtil
	private final FileUtil fileUtil;
	private final FileStore fileStore;
	
	@Override
	public String upload(File file) {
		
		// TODO Implements method
		try {
			this.fileStore.writeFile(file.getName(), Files.readAllBytes(file.toPath()));
		} catch (FileAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public String delete(String fileName) {

		// TODO Implements method		
		this.fileStore.deleteFile(fileName);
		
		return null;
	}
	@Override
	public byte[] download(String fileName) {

		// TODO Implements method		
		return this.fileStore.readFile(fileName);
	}
	@Override
	public List<String> listFiles() {

		// TODO Implements method		
		return this.fileStore.listFiles();
	}
	@Override
	public List<String> listFilesNameLike(String nameLike) {

		// TODO Implements method
		List<String> list = this.fileStore.listFiles();
		
		List<String> result = new ArrayList<>();
		for(String item : list) {
			if(item.contains(nameLike)) {
				result.add(item);
			}
		}
		
		return result;
	}
    
}
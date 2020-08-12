package projeto_rafabrito_dropbox_services;

import java.io.File;

public class FolderIsEmpty {
	
	public boolean IsEmpty(String pathStr) {
		File path = new File(pathStr);
		File[] files = path.listFiles(File::isFile);
		
		return files.length == 0 ? true : false;
	}

}

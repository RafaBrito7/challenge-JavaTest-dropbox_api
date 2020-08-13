package projeto_rafabrito_dropbox_services;

import java.io.File;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderErrorException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;

public class GetFilesOrFolders {

	public void getFilesDb(DbxClientV2 client) throws ListFolderErrorException, DbxException {
		ListFolderResult result = client.files().listFolder("/TESTE DROPBOX");

		int count = 0;
		
		System.out.println("In the Path: " + "root/TESTE DROPBOX");

		while (true) {
			for (Metadata metadata : result.getEntries()) {
				System.out.println((count + 1) + " - [" + metadata.getName() + "]");
				count++;
			}

			if (!result.getHasMore()) {
				System.out.println("Total Files in your DropBox = " + count);
				break;
			}

			result = client.files().listFolderContinue(result.getCursor());
		}
	}

	public void getFilesPath(String pathStr) {
		int count = 0;
		
		File path = new File(pathStr);
		File[] files = path.listFiles(File::isFile);
		
		System.out.println("FILES:");
		for (File file : files) {
			System.out.println((count + 1) + " - [" + file.getName() + "]");
			count++;
		}

	}

}

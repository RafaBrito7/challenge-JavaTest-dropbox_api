package projeto_rafabrito_dropbox_resources;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderErrorException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;

public class GetFilesOrFolders {
	
	public void getFiles(DbxClientV2 client) throws ListFolderErrorException, DbxException {
		ListFolderResult result = client.files().listFolder("");
		
		int count = 0;
		
		while (true) {
			for (Metadata metadata : result.getEntries()) {
				System.out.println((count + 1) + " - [" + metadata.getPathLower() + "]");
				count++;
			}
			
			if (!result.getHasMore()) {
				System.out.println("Total Files and Folders = " + count);
				break;
			}
			
			result = client.files().listFolderContinue(result.getCursor());
		}
	}
	
	

}

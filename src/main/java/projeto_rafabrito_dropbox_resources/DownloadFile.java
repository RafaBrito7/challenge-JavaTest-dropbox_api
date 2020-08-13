package projeto_rafabrito_dropbox_resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

public class DownloadFile {

	public void downloadOne(DbxClientV2 client, String pathPc, String fileName) {
		try {
			OutputStream downloadFile = new FileOutputStream(pathPc + "\\" + fileName);
			try {
				FileMetadata metadata = client.files().downloadBuilder("/TESTE DROPBOX/" + fileName).download(downloadFile);
			} finally {
				downloadFile.close();
				System.out.println("Download Success!");
			}
		}
		catch(DbxException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

}


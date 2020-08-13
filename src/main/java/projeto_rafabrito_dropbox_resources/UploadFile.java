package projeto_rafabrito_dropbox_resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.WriteMode;

public class UploadFile {

	public void uploadOne(DbxClientV2 client, String path) {
		try {
			File file = new File(path);
			InputStream fileUpload = new FileInputStream(file);
			client.files().uploadBuilder("/TESTE DROPBOX/" + file.getName()).withMode(WriteMode.OVERWRITE)
					.uploadAndFinish(fileUpload);

			System.out.println("Upload Success!");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void uploadAll(DbxClientV2 client, String path) {
		try {
			File file = new File(path);
			File[] filesList = file.listFiles(File::isFile);
			
			for (File file2 : filesList) {
				InputStream fileUpload = new FileInputStream(file2);
				client.files().uploadBuilder("/TESTE DROPBOX/" + file2.getName()).withMode(WriteMode.OVERWRITE)
				.uploadAndFinish(fileUpload);
				
				System.out.println(file2.getName() + " - Uploaded!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

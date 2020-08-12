package projeto_rafabrito_dropbox_resources;

import java.io.FileInputStream;
import java.io.InputStream;

import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

public class UploadFile {
	
	public void upload(DbxClientV2 client) {
		try (InputStream in = new FileInputStream("D:\\Documentos\\_DesenvolvedorArquivos\\_Projetos_JAVA\\Projeto_integracao_gdrive\\TESTE DROPBOX\\1.png")) {
            FileMetadata metadata = client.files().uploadBuilder("/TESTE DROPBOX/1.png")
                .uploadAndFinish(in);
            System.out.println("Upload Success!");
        }
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}

package projeto_rafabrito_dropbox_services;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

public class CreateClient {
	private static final String ACCESS_TOKEN = "";

	public DbxClientV2 creatClient() {
		// Criando Dropbox Client
		DbxRequestConfig config = DbxRequestConfig.newBuilder("projeto-dropbox").build();
		DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
		
		return client;
	}
	

}

package projeto_rafabrito_dropbox_services;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;

public class GetAccountInfo {

	public void getAccountInfo(DbxClientV2 client) {
		try {
			FullAccount account = client.users().getCurrentAccount();
			System.out.println("Logged Account Informations API: ");
			System.out.println("- Name:   " + account.getName().getDisplayName());
			System.out.println("- Email:  " + account.getEmail());
			System.out.println("- Acc ID: " + account.getAccountId());

		} catch (DbxApiException e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
			
		} catch (DbxException e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
	}

}

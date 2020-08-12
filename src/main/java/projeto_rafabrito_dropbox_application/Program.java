package projeto_rafabrito_dropbox_application;

import java.util.Scanner;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderErrorException;

import projeto_rafabrito_dropbox_resources.CreateClient;
import projeto_rafabrito_dropbox_resources.GetAccountInfo;
import projeto_rafabrito_dropbox_resources.GetFilesOrFolders;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CreateClient creatCl = new CreateClient();

		DbxClientV2 client = creatCl.creatClient();

		// Confirmação de que está logado no meu DropBox
		System.out.println("Do you want to see account information?(Y/N)");
		Character answer = sc.next().charAt(0);

		if (Character.toUpperCase(answer) == 'Y') {
			GetAccountInfo getAccountInfo = new GetAccountInfo();
			getAccountInfo.getAccountInfo(client);
		}

		System.out.println("A List of all your Files and Folders: ");

		GetFilesOrFolders files = new GetFilesOrFolders();

		try {
			files.getFiles(client);

		} catch (ListFolderErrorException e) {
			e.printStackTrace();

		} catch (DbxException e) {
			e.printStackTrace();
		}
		
		System.out.println("Enter a Path in your PC to sincronyze with DropBox: ");
		String path = sc.nextLine();

		sc.close();
	}

}

package projeto_rafabrito_dropbox_application;

import java.util.Scanner;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderErrorException;

import projeto_rafabrito_dropbox_resources.UploadFile;
import projeto_rafabrito_dropbox_services.CreateClient;
import projeto_rafabrito_dropbox_services.FolderIsEmpty;
import projeto_rafabrito_dropbox_services.GetAccountInfo;
import projeto_rafabrito_dropbox_services.GetFilesOrFolders;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CreateClient creatCl = new CreateClient();
		GetFilesOrFolders files = new GetFilesOrFolders();
		FolderIsEmpty empty = new FolderIsEmpty();
		UploadFile uploadFile = new UploadFile();

		DbxClientV2 client = creatCl.creatClient();

		// Confirmação de que está logado no meu DropBox (Acess_Code)
		System.out.println("Do you want to see account information?(Y/N)");
		Character answer = sc.next().charAt(0);

		if (Character.toUpperCase(answer) == 'Y') {
			GetAccountInfo getAccountInfo = new GetAccountInfo();
			getAccountInfo.getAccountInfo(client);
		}

		System.out.println("The List of all your Files and Folders in DropBox Folder: ");
		
		// Método para Listar os arquivos da Pasta que eu Escolhi no DropBox
		try {
			files.getFilesDb(client);

		} catch (ListFolderErrorException e) {
			e.printStackTrace();

		} catch (DbxException e) {
			e.printStackTrace();
		}
		
		// Consumidora de Linha em branco(bug do Scanner)
		sc.nextLine();
		
		
		System.out.println("Enter a Path in your PC to sincronyze the files with DropBox: ");
		String path = sc.nextLine(); 
		
		if (empty.IsEmpty(path)) {
			System.out.println("Pasta Vazia!");
			//Colocar Exception Personalizada
			System.exit(0);
		} else {
			files.getFilesPath(path);
		}
		
		System.out.println("Do you want to upload the files to DropBox?");
		answer = sc.next().charAt(0);

		if (Character.toUpperCase(answer) == 'Y') {
			uploadFile.upload(client);
		}

		System.out.println("Your Files in DropBox Updated: ");
		try {
			files.getFilesDb(client);
		} 
		catch (DbxException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}

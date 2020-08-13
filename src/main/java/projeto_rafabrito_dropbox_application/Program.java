package projeto_rafabrito_dropbox_application;

import java.util.Scanner;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderErrorException;

import projeto_rafabrito_dropbox_resources.DownloadFile;
import projeto_rafabrito_dropbox_resources.UploadFile;
import projeto_rafabrito_dropbox_services.CreateClient;
import projeto_rafabrito_dropbox_services.FolderIsEmpty;
import projeto_rafabrito_dropbox_services.GetAccountInfo;
import projeto_rafabrito_dropbox_services.GetFilesOrFolders;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CreateClient creatCl = new CreateClient();
		GetFilesOrFolders getFiles = new GetFilesOrFolders();
		FolderIsEmpty empty = new FolderIsEmpty();
		UploadFile uploadFile = new UploadFile();
		DownloadFile downloadFile = new DownloadFile();

		DbxClientV2 client = creatCl.creatClient();

		// Confirmação de que está logado no meu DropBox (Acess_Code)
		// Mudar o ACCESS_TOKEN ao Startar a Aplicação na Class CreateClient
		System.out.println("Do you want to see account information?(Y/N)");
		Character answer = sc.next().charAt(0);

		if (Character.toUpperCase(answer) == 'Y') {
			GetAccountInfo getAccountInfo = new GetAccountInfo();
			getAccountInfo.getAccountInfo(client);
		}

		System.out.println("The List of all your Files in DropBox Folder: ");

		// Método para Listar os arquivos da Pasta que eu Escolhi no DropBox
		try {
			getFiles.getFilesDb(client);

		} catch (ListFolderErrorException e) {
			e.printStackTrace();

		} catch (DbxException e) {
			e.printStackTrace();
		}

		// Consumidora de Linha em branco(bug do Scanner)
		sc.nextLine();

		System.out.println();
		System.out.println("Enter a Path in your PC to see the files: ");
		String path = sc.nextLine();

		if (empty.IsEmpty(path)) {
			System.out.println("Pasta Vazia!");
			// Colocar Exception Personalizada
			System.exit(0);
		} else {
			getFiles.getFilesPath(path);
		}

		System.out.println();
		System.out.println("Do you want to upload One file to DropBox?(Y/N)");
		answer = sc.next().charAt(0);

		sc.nextLine();
		if (Character.toUpperCase(answer) == 'Y') {
			System.out.println("Choose a File and Enter the Path with the File Name");
			System.out.println("[Example: D:\\Documentos\\img01.png]");
			path = sc.nextLine();

			uploadFile.uploadOne(client, path);
		}

		System.out.println("Your Files in DropBox Updated: ");
		try {
			getFiles.getFilesDb(client);
		} catch (DbxException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("Do yout want Upload all Files in the Path?(Y/N)");
		answer = sc.next().charAt(0);

		if (Character.toUpperCase(answer) == 'Y') {
			uploadFile.uploadAll(client, path);
			System.out.println("All Files are Uploaded!");
		}
		
		System.out.println();
		System.out.println("Do your want to Download One File in the Path?(Y/N)");
		answer = sc.next().charAt(0);

		sc.nextLine();
		if (Character.toUpperCase(answer) == 'Y') {
			System.out.println("Enter a Path in your PC to download File: ");
			String pathPc = sc.nextLine();
			System.out.println("Enter a name of File to Download: ");
			String pathDb = sc.nextLine();
			
			downloadFile.downloadOne(client, pathPc, pathDb);
			System.out.println("All Files are Downloaded!");
		}

		sc.close();
	}

}

package projeto_rafabrito_dropbox_application;

import java.util.Scanner;

import com.dropbox.core.v2.DbxClientV2;

import projeto_rafabrito_dropbox_resources.CreateClient;
import projeto_rafabrito_dropbox_resources.GetAccountInfo;

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
		
		sc.close();
	}

}

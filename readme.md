# Integração API DropBox com Java Puro

## Desafio Prático de um Processo Seletivo para Desenvolvedor Java Jr.

### Faltando terminar, Última Modificação 13/08/2020 ás 00h

## Como testar a aplicação:

	- Como utilizei Java puro, você terá que baixar o .zip ou clonar o repositório pro seu PC
	- Utilize a IDE do seu gosto desde que tenha o Java 14 (Foi o que Utilizei) com a JRE 1.8
	- Por falta de tempo (Culpa minha) não consegui implementar Exceptions Personalizadas, nem uma Programação Defensiva 
	
	1. Será Necessário utilizar um Access_Token, fornecido no Dropbox Developers
	2. No Package Services, entre na Classe CreateClient e Cole o seu Access_Token na variável correspondente
	3. Crie no seu DropBox uma Pasta chamada "TESTE DROPBOX" (Ela será a que faremos as operações de Upload e Download)
	4. Crie em algum lugar do seu Computador uma pasta com o mesmo nome "TESTE DROPBOX"
	5. Execute o Programa na sua IDE
	6. Para confirmar que o seu Access_Token está correto, digite "y" na primeira pergunta que aparece no seu Console, assim você verá suas principais informações da sua conta do DropBox
	7. Logo em Seguida Te mostrará também todos os arquivos que você tem nessa pasta chamada "TESTE DROPBOX" do seu dropbox
	8. Insira alguns arquivos na pasta "TESTE DROPBOX" do seu PC (Recomendo .txt e .png para testarmos já que são arquivos leves)
	9. Insira o Diretório da sua pasta "TESTE DROPBOX" do seu PC no Console conforme solicitado (Ex: c:/temp/TESTE DROPBOX)
	10. O Programa listará todos os arquivos que você tem nesse diretório
	11. Você Decidirá se vai querer realizar o Upload de apenas 1 arquivo da Lista que foi mostrada
		a. Caso sua resposta seja "Y"
			i. insira o diretório da sua pasta + o nome do arquivo. (Exemplo: c:\Documentos\TESTE DROPBOX\img01.png)
			
	12. Você verá uma lista atualizada de todos os seus arquivos do DropBox, inclusive o recém upado
	13. Você decidirá se deseja upar todos os arquivos da pasta TESTE DROPBOX para a sua pasta na nuvem
	14. Você verá o nome dos arquivos que estão sendo upados e a mensagem de que foram upados.
	15. Você decidirá se deseja baixar 1 arquivo
		a. Caso sua resposta seja "Y"
			i. insira o diretório que você quer que o arquivo seja salvo no seu Computador (Ex: D:\Imagens)
			ii. insira o nome do arquivo desejado (Ex: 1511375.png)
	16. Fim da Aplicação

### Pretendo Continuar desenvolvendo essa aplicação, por enquanto ela se encontra "EM CONSTRUÇÃO"
## Última Modificação 13/08/2020 ás 00h

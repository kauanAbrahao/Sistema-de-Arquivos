package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosController implements InterfaceArquivosController {

	@Override
	public void verificaDirTemp(String caminho) throws IOException {
		File dir = new File(caminho);
		if(dir.exists()) {
			System.out.println("Diretório já existe");
		} else {
			dir.mkdir();
			System.out.println("Diretório criado");
		}
	}

	@Override
	public boolean verificaRegistro(String arquivo, String caminho, int codigo) throws IOException {
		
		File arq = new File(caminho, arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader reader = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			while(linha!=null) {
				String[] parte = linha.split("\\,");
				int c = Integer.parseInt(parte[0]);
				if(c == codigo) {
					return true;
				}
				linha = buffer.readLine();
			}
		}
		return false;
	}

	@Override
	public void imprimeCadastro(String arquivo, String caminho, int codigo) throws IOException {
		File arq = new File(caminho, arquivo);
		if(verificaRegistro(arquivo, caminho, codigo)) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader reader = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			while(linha!=null) {
				String[] parte = linha.split("\\,");
				int c = Integer.parseInt(parte[0]);
				if(c == codigo) {
					System.out.println("Código: " + parte[0] + "\nNome: " + parte[1] + "\nEmail: " + parte[2]);
				}
				linha = buffer.readLine();
			}
			
			
		} else {
			System.out.println("Código não encontrado");
		}
	}

	@Override
	public void insereCadastro(String arquivo, String caminho, int codigo, String nome, String email) throws IOException {
		if(!verificaRegistro(arquivo, caminho, codigo)) {
			File arq = new File(caminho, arquivo);
			String conteudo = codigo + "," + nome + "," + email + "\n";
			FileWriter writer = new FileWriter(arq, true);
			PrintWriter print = new PrintWriter(writer);
			print.write(conteudo);
			print.flush();
		}
	}


}

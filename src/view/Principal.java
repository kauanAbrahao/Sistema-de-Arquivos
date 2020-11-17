package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.InterfaceArquivosController;

public class Principal {
	public static void main(String[] args) {
		InterfaceArquivosController iarquivos = new ArquivosController();
		String caminho = "C:\\TEMP";
		String arquivo = "teste.csv";
		
		
		int codigo = 90;
		String nome = "dudu";
		String email = "dududoidao@hotmail.com";
		
		try {
			iarquivos.verificaDirTemp(caminho);
			iarquivos.imprimeCadastro(arquivo, caminho, codigo);
			iarquivos.insereCadastro(arquivo, caminho, codigo, nome, email);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

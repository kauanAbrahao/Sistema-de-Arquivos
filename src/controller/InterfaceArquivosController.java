package controller;

import java.io.IOException;

public interface InterfaceArquivosController {
	public void verificaDirTemp(String caminho) throws IOException;
	public boolean verificaRegistro(String arquivo, String caminho, int codigo) throws IOException;
	public void imprimeCadastro(String arquivo, String caminho, int codigo) throws IOException;
	public void insereCadastro(String arquivo, String caminho, int codigo, String nome, String email) throws IOException;

}

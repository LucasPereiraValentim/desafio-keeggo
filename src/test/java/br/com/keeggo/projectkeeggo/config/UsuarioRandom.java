package br.com.keeggo.projectkeeggo.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class UsuarioRandom {
	
	public static String nomeUsuario;
	
	private String[] letras;
	
	public static String email;
	
	public static String fistName;
	
	public static String lastName;
	
	public UsuarioRandom() {
		this.letras = new String[]
				{"A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q",
				"R", "S", "T", "U", "V", "W", "Y", "Z"};
		nomeUsuario = "";
	}
	
	public void gerarNomeDeUsuarioAleatorio() {
		for (int i = 1; i <= 8; i++) {
			int n = new Random().nextInt(24);
			nomeUsuario += this.letras[n];
		}
		email = nomeUsuario;	
	}
	public void gravarUserNameFileTxt() {
		File file = new File( System.getProperty("user.dir") +
				"\\name-user");
		file.mkdirs();
		File filePdf = new File(file.getAbsolutePath() + File.separator + "userName1.txt");
		
		try {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(filePdf));
			buffWrite.append(nomeUsuario);
			buffWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lerFileTxt() {
		File filePdf = new File(System.getProperty("user.dir") + "\\name-user", "userName1.txt");
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(filePdf));
			nomeUsuario = buffReader.readLine();
			buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void gerarNomeESobrenome() {
		fistName = nomeUsuario.substring(0, 2);
		lastName = nomeUsuario.substring(3, 7);
	}
}

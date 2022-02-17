package br.com.keeggo.projectkeeggo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UsuarioRandom {
	
	public static String nomeUsuario;
	
	public static String email;
	
	public static String firstName;
	
	public static String lastName;
	
	private int httpStatus;
	
	public UsuarioRandom() {
		this.httpStatus = 200;
		try {
			this.consumirApiNomeAleatorio();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void gravarUserNameFileTxt() {
		File file = new File( System.getProperty("user.dir") +
				"\\name-user");
		file.mkdirs();
		File fileText = new File(file.getAbsolutePath() + File.separator + "userName.txt");
		
		try {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(fileText));
			buffWrite.append(nomeUsuario);
			buffWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public static void lerFileTxt() {
		File fileText = new File(System.getProperty("user.dir") + "\\name-user", "userName.txt");
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(fileText));
			nomeUsuario = buffReader.readLine();
			buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public void consumirApiNomeAleatorio() throws Exception{
		HttpURLConnection connection = null;
		try {
			URL url = new URL("http://gerador-nomes.herokuapp.com/nome/aleatorio");
			connection = (HttpURLConnection) url.openConnection();
			
			if (connection.getResponseCode() != this.httpStatus) {
				throw new Exception("Erro ao consumir API para gerar nome aleatório");
			}
			
			BufferedReader retornoApi = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
			String nomeCompleto = "";
			
			nomeCompleto = retornoApi.readLine();
			
			List<String> list = new ArrayList<>(Arrays.asList(nomeCompleto.split(",")));
			
			this.atribuirNomeAleatorio(list.get(0).replace("[", "").replace("\"", ""), list.get(1).replace("\"", "").replace("]", ""));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
}
	
	
	public void atribuirNomeAleatorio(String nome, String sobrenome) {
		
		int tamanho = this.retirarAcentosUsuario(nome, sobrenome).length();
		if (tamanho > 15) {
			nomeUsuario = this.retirarAcentosUsuario(nome, sobrenome).substring(0, 14);
		} else {
			nomeUsuario = this.retirarAcentosUsuario(nome, sobrenome);
		}
		firstName = nome;
		lastName = sobrenome;
		email = this.retirarAcentosUsuario(nome, sobrenome).toLowerCase() + "@teste.com".replace(" ", "");
	}
	
	
	public String retirarAcentosUsuario(String nome, String sobrenome) {
		String str = nome + sobrenome;
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
}

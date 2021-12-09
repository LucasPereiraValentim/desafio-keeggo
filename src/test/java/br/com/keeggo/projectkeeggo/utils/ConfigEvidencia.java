package br.com.keeggo.projectkeeggo.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ConfigEvidencia {

	public static Document doc;

	public static String nameFile;

	public static int cont = 0;
	
	// Criação de arquivo pdf
	public void configuracoesEvidences() {
		String dataEvidence = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
		File file = new File(System.getProperty("user.dir") + "\\evidences\\" + dataEvidence);
		file.mkdirs();
		File filePdf = new File(file.getAbsolutePath() + File.separator + nameFile.replace(" ", "_").toLowerCase() + ".pdf");
		try {
			this.criarPdf(filePdf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void criarPdf(File file) throws Exception {
		doc = new Document(PageSize.A4);
		FileOutputStream outStream = new FileOutputStream(file);
		PdfWriter.getInstance(doc, outStream);
		doc.open();
		doc = addCabecalhoPdf(doc);

	}
	
	
	// Adiciona cabeçalho
	public Document addCabecalhoPdf(Document doc) throws DocumentException {

		String initTestTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

		Font fontCabecalho = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);

		String executadorTeste = System.getProperty("user.name");

		PdfPTable tableHeader = new PdfPTable(new float[] { 0.15f, 0.35f, 0.13f, 0.37f });

		PdfPCell header = new PdfPCell(new Paragraph("Info Teste", fontCabecalho));

		header.setUseBorderPadding(true);
		header.setBorderColor(BaseColor.BLACK);
		header.setHorizontalAlignment(Element.ALIGN_CENTER);

		header.setColspan(4);
		tableHeader.setSpacingBefore(20);

		PdfPCell infoProjeto = new PdfPCell(new Paragraph("Projeto", fontCabecalho));
		PdfPCell nameProjeto = new PdfPCell(new Paragraph("Projeto Web Keeggo", fontCabecalho));
		PdfPCell infoTester = new PdfPCell(new Paragraph("Analista", fontCabecalho));
		PdfPCell nameTester = new PdfPCell(new Paragraph(executadorTeste, fontCabecalho));
		PdfPCell infoDataHora = new PdfPCell(new Paragraph("Data", fontCabecalho));
		PdfPCell dataHora = new PdfPCell(new Paragraph(initTestTime, fontCabecalho));
		PdfPCell infoDescricao = new PdfPCell(new Paragraph("Cenário", fontCabecalho));
		PdfPCell nameDescricao = new PdfPCell(new Paragraph(nameFile, fontCabecalho));

		tableHeader.addCell(infoProjeto);
		tableHeader.addCell(nameProjeto);
		tableHeader.addCell(infoTester);
		tableHeader.addCell(nameTester);
		tableHeader.addCell(infoDataHora);
		tableHeader.addCell(dataHora);
		tableHeader.addCell(infoDescricao);
		tableHeader.addCell(nameDescricao);

		doc.add(tableHeader);

		return doc;
	}

	
	// Tira screenshot de todas pages por qual o teste passa
	public void gerarScreenshot(WebDriver browser) {
		try {
			TakesScreenshot ts = (TakesScreenshot) browser;
			File photo = ts.getScreenshotAs(OutputType.FILE);

			cont++;

			FileUtils.copyFile(photo,
					new File(System.getProperty("user.dir") + "\\evidences-images\\" + cont + ".png"));

			Image fileName = Image.getInstance(System.getProperty("user.dir") + "\\evidences-images\\" + cont + ".png");
			
			fileName.scaleAbsolute(400f, 400f);

			doc.add(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void fecharPdf() {
		doc.close();
	}
}

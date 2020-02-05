package br.com.rsinet.hub_tdd.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Prints {

	/* Atribui data e hora ao nomear o arquivo de print. */
	public static String timestamp() {
		return new SimpleDateFormat(" yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	/*
	 * Cria um arquivo de imagem e atribui um nome a ele especificado na declaração
	 * do metodo.
	 */
	public static String tirarPrints(WebDriver driver, String nomeDaImagem) throws Exception {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destino = System.getProperty("user.dir") + "/target/" + nomeDaImagem + timestamp() + ".png";

        try {
            FileUtils.copyFile(file, new File(destino));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destino;
	}
}

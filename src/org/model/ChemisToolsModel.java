/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import javax.swing.ImageIcon;

/**
 *
 * @author guilherme
 */
public class ChemisToolsModel {

    private static ChemisToolsModel instance;
    private HashMap<String, ImageIcon> images;
    private FileHandler fileHandler = null;
    private SimpleFormatter formatter = new SimpleFormatter();

    private ChemisToolsModel() {
        images = new HashMap<>();
    }

    public static ChemisToolsModel getInstance() {
        if (instance == null) {
            instance = new ChemisToolsModel();
        }
        return instance;
    }

    public ImageIcon getImage(String url) {
        if (images.containsKey(url)) {
            return images.get(url);
        } else {
            images.put(url, new ImageIcon(getClass().getResource(url)));
            return images.get(url);
        }
    }

    public String requestHTTP(String urlString) throws MalformedURLException, IOException {
        System.setProperty("http.proxyHost", "10.1.1.1");
        System.setProperty("http.proxyPort", "8080");

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("Request-Method", "GET");
        connection.setDoInput(true);
        connection.setDoOutput(false);

        connection.connect();

        return convertToString(connection.getInputStream());
    }

    private String convertToString(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer newData = new StringBuffer(10000);
        String s = "";
        while (null != ((s = br.readLine()))) {
            newData.append(s);
        }
        br.close();

        return new String(newData);
    }

    public String getJarPath() {
        return ChemisToolsModel.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    }

    public FileHandler getLogFileHandler() {
        if (fileHandler == null) {
            try {
                fileHandler = new FileHandler(System.getProperty("user.home") + "/log_chemis.log", 1024 * 1024, 1, true);
            } catch (IOException | SecurityException ex) {
                System.out.println(ex.getMessage());
            }
            fileHandler.setFormatter(formatter);
        }
        return fileHandler;
    }

    public String exceptionToString(Throwable tr) {
        StringWriter errors = new StringWriter();
        tr.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }
}

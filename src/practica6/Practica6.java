/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import org.w3c.dom.*; 

import javax.xml.parsers.*;
import org.xml.sax.SAXException;

/**
 *
 * @author rodrigo
 */
public class Practica6 {

    /**
     * @param args the command line arguments
     */
    
    private final static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws ParserConfigurationException {
        añadirAtributo();
        System.out.println("Introduce una opción ");
        System.out.println("- 1 Añadir nuevo item");
        System.out.println("- 2 Borrar un objeto item");
        System.out.println("- 3 Modificar un dato");
        System.out.println("- 4 Listar los datos de un escritor");
        System.out.println("- 5 Listar todos los datos de todos los escritores");
    }
    
    public static void añadirAtributo() throws ParserConfigurationException {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File("EscritoresXML.xml"));
            NodeList escritores = document.getElementsByTagName("escritores");
            System.out.print("Introduce el tipo de elemento a añadir: ");
            String atributo;
            atributo = in.nextLine();
            for(int i = 0; i<escritores.getLength(); i++) {
                Node escritor = document.getElementsByTagName("escritores").item(i);
                Element atributoNuevo = document.createElement(atributo);
                System.out.format("Inserte '%s' del escritor %s", atributo, document.getElementsByTagName("escritores").item(i).getTextContent());
                String valorAtributo = in.nextLine();
                atributoNuevo.setTextContent(valorAtributo);
                escritor.appendChild(atributoNuevo);
            }
            EscritoresXMLScanner scanner = new EscritoresXMLScanner(document);

            scanner.visitDocument();
        } catch(ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
   
    
    
    public static void borrarAtributo() {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File("EscritoresXML.xml"));
            NodeList escritores = document.getElementsByTagName("escritores");
            System.out.print("Introduce el tipo de elemento a borrar: ");
            String atributo;
            atributo = in.nextLine();
            for(int i = 0; i<escritores.getLength(); i++) {
                Node escritor = document.getElementsByTagName("escritores").item(i);
                NodeList elemento = escritor.getChildNodes();
                for(int x = 0; x<elemento.getLength(); x++) {
                    Node elementoActual = elemento.item(x);
                    if(elementoActual.getNodeName().equalsIgnoreCase(atributo)) {
                        escritor.removeChild(elementoActual);
                    }
                }
                
            }
            
        } catch(ParserConfigurationException | SAXException | IOException e) {
            
        }
    }
    
    /*
    public static void leerDatosEscritor(String nombre) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File("PruebaXMLDocument.xml"));
            NodeList escritores = document.getElementsByTagName("escritores");
            for(int i = 0; i<escritores.getLength(); i++) {
                Node escritor = document.getElementsByTagName("escritores").item(i);
                escritor.
            }  
        } catch(ParserConfigurationException | SAXException | IOException e) {
            
        } 
    }
    */
    public static void guardarXMLBinario() {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File("PruebaXMLDocument.xml"));
            NodeList escritores = document.getElementsByTagName("escritores");
            for(int i = 0; i<escritores.getLength(); i++) {
                
            }
        } catch(ParserConfigurationException | SAXException | IOException e) {
            
        }        
    }
    
    public static void guardarBinario(File archivo, String contenido) throws FileNotFoundException {
        RandomAccessFile raf;
        raf = new RandomAccessFile(archivo, "rw");
        try {
            raf.writeUTF(contenido);
        } catch(Exception e) {
            
        }
    }
    
    public static String cargarBinario(File archivo) throws FileNotFoundException {
        RandomAccessFile raf;
        String devolver;
        devolver = "";
        raf = new RandomAccessFile(archivo, "rw");
        try {
            devolver =  raf.readUTF();
        } catch(Exception e) {
            
        }
        
        return devolver;
    }
}

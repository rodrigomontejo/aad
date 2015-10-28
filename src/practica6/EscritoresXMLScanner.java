/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

/**
 *
 * @author rodrigo
 */
public class EscritoresXMLScanner {
    /**
     * org.w3c.dom.Document document
     */
    org.w3c.dom.Document document;

    /**
     * Create new EscritoresXMLScanner with org.w3c.dom.Document.
     */
    public EscritoresXMLScanner(org.w3c.dom.Document document) {
        this.document = document;
    }

    /**
     * Scan through org.w3c.dom.Document document.
     */
    public void visitDocument() {
        org.w3c.dom.Element element = document.getDocumentElement();
        if ((element != null) && element.getTagName().equals("escritores")) {
            visitElement_escritores(element);
        }
        if ((element != null) && element.getTagName().equals("escritor")) {
            visitElement_escritor(element);
        }
        if ((element != null) && element.getTagName().equals("nombre")) {
            visitElement_nombre(element);
        }
        if ((element != null) && element.getTagName().equals("nacimiento")) {
            visitElement_nacimiento(element);
        }
    }

    /**
     * Scan through org.w3c.dom.Element named escritores.
     */
    void visitElement_escritores(org.w3c.dom.Element element) {
        // <escritores>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("escritor")) {
                        visitElement_escritor(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named escritor.
     */
    void visitElement_escritor(org.w3c.dom.Element element) {
        // <escritor>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("nombre")) {
                        visitElement_nombre(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("nacimiento")) {
                        visitElement_nacimiento(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named nombre.
     */
    void visitElement_nombre(org.w3c.dom.Element element) {
        // <nombre>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
                case org.w3c.dom.Node.TEXT_NODE:
                    // ((org.w3c.dom.Text)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named nacimiento.
     */
    void visitElement_nacimiento(org.w3c.dom.Element element) {
        // <nacimiento>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
                case org.w3c.dom.Node.TEXT_NODE:
                    // ((org.w3c.dom.Text)node).getData();
                    break;
            }
        }
    }
    
}

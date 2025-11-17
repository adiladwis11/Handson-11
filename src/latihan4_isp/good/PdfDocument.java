package latihan4_isp.good;

public class PdfDocument implements Readable, Printable {
    private String name;

    public PdfDocument(String name) {
        this.name = name;
    }

    @Override
    public void read() {
        System.out.println("[PdfDocument] Reading PDF: " + name);
    }

    @Override
    public void print() {
        System.out.println("[PdfDocument] Printing PDF: " + name);
    }
}

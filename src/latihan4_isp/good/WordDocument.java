package latihan4_isp.good;

public class WordDocument implements Readable, Editable, Printable {
    private String name;

    public WordDocument(String name) {
        this.name = name;
    }

    @Override
    public void read() {
        System.out.println("[WordDocument] Reading Word: " + name);
    }

    @Override
    public void edit(String content) {
        System.out.println("[WordDocument] Editing Word: " + name + " with content: " + content);
    }

    @Override
    public void print() {
        System.out.println("[WordDocument] Printing Word: " + name);
    }
}

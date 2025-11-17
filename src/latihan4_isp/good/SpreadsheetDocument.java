package latihan4_isp.good;

public class SpreadsheetDocument implements Readable, Editable, Printable, Calculable {
    private String name;

    public SpreadsheetDocument(String name) {
        this.name = name;
    }

    @Override
    public void read() {
        System.out.println("[SpreadsheetDocument] Reading Spreadsheet: " + name);
    }

    @Override
    public void edit(String content) {
        System.out.println("[SpreadsheetDocument] Editing Spreadsheet: " + name + " with content: " + content);
    }

    @Override
    public void calculate(String formula) {
        System.out.println("[SpreadsheetDocument] Calculating formula: " + formula);
    }

    @Override
    public void print() {
        System.out.println("[SpreadsheetDocument] Printing Spreadsheet: " + name);
    }
}

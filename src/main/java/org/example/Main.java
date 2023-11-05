package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        XSSFReader reader = new XSSFReader();
        reader.universityReader();
        reader.studentReader();
        /*
        простите, два дня плотно посидел над проектом так и не понял как мне сделать чтобы XSSFReader был привязан
        по оформлению к Student и University, знаю про getRow().getCell()
        */
    }
}
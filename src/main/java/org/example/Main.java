package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        XSSFReader reader = new XSSFReader();
        reader.universityReader();
        reader.studentReader();
        /**
         * простите, два дня плотно посидел над проектом так и не понял как мне сделать чтобы XSSFReader был привязан
         *         по оформлению к Student и University, знаю про getRow().getCell(), но они выбирают конкретную ячейку,
         *         через цикл for и просто i=0 в цикле while увеличивал на 1, все равно не работало так как задумывал,
         *         по этому пока не знаю что делать, может снизойдет на меня озарение и я пойму как это сделать
         */
    }
}
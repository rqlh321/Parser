import model.Item;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Util {
    public static void writeIntoExcel(String file) throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Birthdays");

        List<Item> items=DAO.getItems();
        for (int i=0;i<items.size();i++){
            // Нумерация начинается с нуля
            Row row = sheet.createRow(i);

            // Мы запишем имя и дату в два столбца
            // имя будет String, а дата рождения --- Date,
            // формата dd.mm.yyyy
            Cell name = row.createCell(0);
            name.setCellValue(items.get(0).getType());

            Cell birthdate = row.createCell(1);

            DataFormat format = book.createDataFormat();
            CellStyle dateStyle = book.createCellStyle();
            dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
            birthdate.setCellStyle(dateStyle);


            // Нумерация лет начинается с 1900-го
            birthdate.setCellValue(items.get(i).getDate());
        }


        // Меняем размер столбца
        sheet.autoSizeColumn(1);

        // Записываем всё в файл
        book.write(new FileOutputStream(file));
        book.close();
    }
}

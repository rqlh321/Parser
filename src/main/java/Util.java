import model.Item;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Util {
    public static void writeIntoExcel(String file) throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Prices");

        List<Item> items=DAO.getItems();
        for (int i=0;i<items.size();i++){
            Item item=items.get(i);
            Row row = sheet.createRow(i);

            Cell date = row.createCell(0);
            DataFormat format = book.createDataFormat();
            CellStyle dateStyle = book.createCellStyle();
            dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
            date.setCellStyle(dateStyle);
            date.setCellValue(item.getDate());

            Cell name = row.createCell(1);
            name.setCellValue(item.getName());

            Cell price = row.createCell(2);
            price.setCellValue(item.getPrice());

            Cell address = row.createCell(3);
            address.setCellValue(item.getPage().getAddress());
        }


        // Меняем размер столбца
        sheet.autoSizeColumn(1);

        // Записываем всё в файл
        book.write(new FileOutputStream(file));
        book.close();
    }

    public static String split(String string){
        return string.contains("&")?string.split("&")[0]:string;
    }
}

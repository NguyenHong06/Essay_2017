package readdata;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.w3c.dom.Attr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ReadExcel {
	private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	public static void Writefile(ArrayList<House> lstHouses) throws IOException {
		File file = new File("D:\\LUANVAN\\LV\\data1.xls");
		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		// Lấy ra sheet đầu tiên từ workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFCellStyle style = createStyleForTitle(workbook);
		int n = lstHouses.size();
		for (int i = 0; i < n; i++) {
			ArrayList<String> houseAttrs = lstHouses.get(i).getHouse();
			for (int j = 0; j < houseAttrs.size(); j++) {
				HSSFCell ce = sheet.getRow(i + 1).getCell(j);

				if (houseAttrs.get(j) != null) {
					System.out.println(houseAttrs.get(j));
					ce.setCellValue(houseAttrs.get(j));
				} else {

					ce.setCellValue("N/A");
				}

				ce.setCellStyle(style);
			}
		}

		inputStream.close();

		// Ghi fi
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		out.close();
	}

	public static ArrayList<ArrayList<String>> ReadFile() throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(
				"D:\\LUANVAN\\LV\\data.xls"));
		ArrayList<ArrayList<String>> lstObjs = new ArrayList<>();
		// Đối tượng workbook cho file XSL.
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

		// Lấy ra sheet đầu tiên từ workbook
		HSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		// while (rowIterator.hasNext()) {

//		for (int i = 0; i < 14460; i++) {
			 for (int i = 0; i < 17709; i++){
			
			ArrayList<String> Obj = new ArrayList<String>();
			Row row = rowIterator.next();

			// Lấy Iterator cho tất cả các cell của dòng hiện tại.
			Iterator<Cell> cellIterator = row.cellIterator();
			// while (cellIterator.hasNext()) {
			String attrs = "";
			for (int j = 0; j < 20; j++) {
				Cell cell = cellIterator.next();
				attrs = cell.toString().toLowerCase();
				Obj.add(attrs);
			}
			lstObjs.add(Obj);
		}
		return lstObjs;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<String>> lstObjs = ReadFile();
		ArrayList<ObjectFile> lstObjects = new ArrayList<>();
		for (ArrayList<String> obj : lstObjs) {
			ObjectFile object = new ObjectFile(obj);
			// System.out.println(object.getDientich());
			if (!object.getDientich().equals("không xác định") && !object.getGiatien().equals("thỏa thuận")) {
				lstObjects.add(object);
			}
		}
		ArrayList<House> output = new ArrayList<>();

		for (ObjectFile objectFile : lstObjects) {
			Attributes attr = new Attributes();
			House house = new House();
			attr.getHouse(objectFile);
			house = attr.getHouse(objectFile);
			output.add(house);
		}
		 Writefile(output);
		 
		System.out.println("Done");
	}

}

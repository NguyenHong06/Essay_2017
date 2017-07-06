package readdata;

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



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class temp {
	private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	public static void Writefile(ArrayList<ArrayList<String>> lstString) throws IOException {
		File file = new File("D:\\LUANVAN\\XLDL\\CreateDatabase\\src\\data.xls");
		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		// Lấy ra sheet đầu tiên từ workbook
		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFCellStyle style = createStyleForTitle(workbook);
		
		
		int n = lstString.get(0).size();
		int nk = lstString.size();System.out.println(n);
		for (int k = 1; k < nk; k++)
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 8; j++) {
				HSSFCell ce = sheet.getRow(i).getCell(k);
				//ce = row.createCell(j, CellType.STRING);
				String a = lstString.get(k).get(i);
				
				ce.setCellValue(lstString.get(k).get(i));
				ce.setCellStyle(style);
			}
		}
		
		inputStream.close();

		// Ghi fi
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		out.close();
	}

	public static ArrayList<String> ReadFile() throws IOException {
		FileInputStream inputStream = new FileInputStream(new File("D:\\LUANVAN\\Data\\data.xlsx"));
		ArrayList<String> lstString = new ArrayList<String>();
		// Đối tượng workbook cho file XSL.
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

		// Lấy ra sheet đầu tiên từ workbook
		HSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		// while (rowIterator.hasNext()) {
		for (int i = 0; i < 20; i++) {
			Row row = rowIterator.next();

			// Lấy Iterator cho tất cả các cell của dòng hiện tại.
			Iterator<Cell> cellIterator = row.cellIterator();
			// while (cellIterator.hasNext()) {
			for (int j = 0; j < 18; j++) {
				cellIterator.next();
			}
			Cell cell = cellIterator.next();
			// Đổi thành getCellType() nếu sử dụng POI 4.x
			CellType cellType = cell.getCellTypeEnum();
			String mota = cell.toString();
			mota = mota.toLowerCase();

			lstString.add(mota);
		}
		return lstString;
	}

	public static void main(String[] args) throws IOException {

		ArrayList<ArrayList<String>> kq = new ArrayList<ArrayList<String>>();
		ArrayList<String> lstString = ReadFile();

		ArrayList<String> lstHem = new ArrayList<String>();
		ArrayList<String> lstMattien = new ArrayList<String>();
		ArrayList<String> lstSauLungMattien = new ArrayList<String>();
		ArrayList<String> lstmt = new ArrayList<String>();
		Pattern pt = Pattern.compile("hẻm");
		Pattern pt1 = Pattern.compile("sau lưng mặt tiền");
		Pattern pt2 = Pattern.compile("mặt tiền");
		Pattern pt3 = Pattern.compile("mt");
		for (int i = 0; i < 20; i++) {
			Matcher matcher = pt.matcher(lstString.get(i));
			boolean b1 = matcher.find();
			if (b1 == true){
				lstHem.add("true");}
			else {lstHem.add("t");
			}
			
			Matcher matcher1 = pt1.matcher(lstString.get(i));
			boolean b2 = matcher1.find();
			if (b2)
				lstSauLungMattien.add("true");
			else lstSauLungMattien.add("t");
			
			Matcher matcher2 = pt2.matcher(lstString.get(i));
			boolean b3 = matcher2.find();
			if (b3)
				lstMattien.add("true");
			else lstMattien.add("t");
			Matcher matcher3 = pt3.matcher(lstString.get(i));
			boolean b4 = matcher3.find();
			if (matcher3.find())
				lstmt.add("true");
			else lstmt.add("t");
			
		}
		kq.add(lstHem);		
		kq.add(lstSauLungMattien);
		kq.add(lstMattien);
		kq.add(lstmt);
		for(int i = 0;i < kq.size();i++){
			for(int j = 0;j < kq.get(i).size();j++)
		System.out.print(kq.get(i).get(j) + "   ");
			System.out.println();}
		Writefile(kq);
		
	}

}

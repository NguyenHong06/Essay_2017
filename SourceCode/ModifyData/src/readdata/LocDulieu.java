package readdata;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class LocDulieu {
	private String masoDK;
	private double giatien;
	private double dientich;
	private String quan;
	private int sotang;
	private int sophong;
	private String vitri;
	
	public String viTri() {
		
		String[] pattern = {"bán nhà mặt tiền","bán gấp nhà mt",
				"bán nhà mt","bán nhà riêng măt tiền"};
		Pattern pt = Pattern.compile("hẻm");
		return this.vitri;
	}

}

package Models;

import java.util.Scanner;

public abstract class Services implements Comparable<Services> {
	private String id;
	private String tenDV;
	private String dtichSD;
	private float chiPhi;
	private int soLuong;
	private String kieuThue;
	
	
	public Services() {
		// TODO Auto-generated constructor stub
	}
	public Services(String id, String tenDV, String dtichSD, float chiPhi, int soLuong, String kieuThue) {
		this.id = id;
		this.tenDV = tenDV;
		this.dtichSD = dtichSD;
		this.chiPhi = chiPhi;
		this.soLuong = soLuong;
		this.kieuThue = kieuThue;
	}

	public abstract void showInfo() ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getDtichSD() {
		return dtichSD;
	}

	public void setDtichSD(String dtichSD) {
		this.dtichSD = dtichSD;
	}

	public float getChiPhi() {
		return chiPhi;
	}

	public void setChiPhi(float chiPhi) {
		this.chiPhi = chiPhi;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getKieuThue() {
		return kieuThue;
	}

	public void setKieuThue(String kieuThue) {
		this.kieuThue = kieuThue;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ID");
		setId(sc.nextLine());
		System.out.println("Nhap ten DV");
		setTenDV(sc.nextLine());
		System.out.println("Dien tich su dung");
		setDtichSD(sc.nextLine());
		System.out.println("Chi phi");
		setChiPhi(Float.parseFloat(sc.nextLine()));
		System.out.println("So luong");
		setSoLuong(Integer.parseInt(sc.nextLine()));
		System.out.println("Kieu thue");
		setKieuThue(sc.nextLine());
	}
	
	@Override
    public boolean equals(Object other) {
        if (!(other instanceof Services)) {
            return false;
        }
        return tenDV.equals(((Services)other).tenDV);
    }

    @Override
    public int hashCode() {
        return tenDV.hashCode();
    }
    
    @Override
	public int compareTo(Services arg0) {
		// TODO Auto-generated method stub
		return id.compareTo(arg0.getId());
	}
    
    
}

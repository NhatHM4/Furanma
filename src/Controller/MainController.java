package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import Models.Customer;
import Models.Employee;
import Models.House;
import Models.Phong;
import Models.Services;
import Models.Villa;

public class MainController {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

//			addNewServices(sc);
//			addNewServices(sc);
//			addCustomer();
//			showServices(getServices());
//			for (Customer cs : getDataCustomer()) {
//				cs.showInfo();
//			}
//			Set<Map.Entry<Integer, Customer>> setDic = getDataCustomer().entrySet();
//			for (Entry<Integer, Customer> entry : setDic) {
//				System.out.println("STT " + entry.getKey() + "-->" + " Value: " + entry.getValue().getHoten());
//			}
//		addNewBook(sc);
//		addNewemp(sc);

		Set<Map.Entry<String, Employee>> setListEMP = getEmployee().entrySet();
		for (Entry<String, Employee> entry : setListEMP) {
			System.out.println(entry);
		}
	}

	private static Map<String, Employee> getEmployee() throws IOException {
		Map<String, Employee> listEmp = new HashMap<String, Employee>();
		String line1 = "";
		BufferedReader bff1 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\data\\Employee.txt"));
		while ((line1 = bff1.readLine()) != null) {
			String[] data = line1.split(" ");
			Employee emp = new Employee();
			emp.setHoten(data[1]);
			emp.setNgaysinh(data[2]);
			emp.setCMND(data[3]);
			emp.setSDT(data[4]);
			emp.setEmail(data[5]);
			emp.setTrinhdo(data[6]);
			emp.setVitri(data[7]);
			emp.setLuong(Float.parseFloat(data[8]));
			listEmp.put(data[0], emp);
		}
		bff1.close();
		return listEmp;
	}

	private static void addNewemp(Scanner sc) throws IOException {
		Map<String, Employee> listEmp = new HashMap<String, Employee>();
		Employee nv1 = new Employee("nv1", "07/11", "0123", "5555", "ahihi", "trung cap", "nhan vien", 10.2f);
		Employee nv2 = new Employee("nv2", "07/11", "0123", "5555", "ahihi", "trung cap", "nhan vien", 10.2f);
		Employee nv3 = new Employee("nv3", "07/11", "0123", "5555", "ahihi", "trung cap", "nhan vien", 10.2f);
		Employee nv4 = new Employee("nv4", "07/11", "0123", "5555", "ahihi", "trung cap", "nhan vien", 10.2f);
		Employee nv5 = new Employee("nv5", "07/11", "0123", "5555", "ahihi", "trung cap", "nhan vien", 10.2f);
		Employee nv6 = new Employee("nv6", "07/11", "0123", "5555", "ahihi", "trung cap", "nhan vien", 10.2f);
		listEmp.put("001", nv1);
		listEmp.put("002", nv2);
		listEmp.put("003", nv3);
		listEmp.put("004", nv4);
		listEmp.put("005", nv5);
		listEmp.put("006", nv6);
		saveToFileEmp(listEmp);
	}

	private static void saveToFileEmp(Map<String, Employee> listEmp) throws IOException {
		File file1 = new File("E:\\hoc lap trinh\\data\\Employee.txt");
		OutputStream outputStream1 = null;
		OutputStreamWriter outputStreamWriter1 = null;
		outputStream1 = new FileOutputStream(file1);
		outputStreamWriter1 = new OutputStreamWriter(outputStream1);
		Set<Map.Entry<String, Employee>> setListEMP = listEmp.entrySet();
		for (Entry<String, Employee> entry : setListEMP) {
			outputStreamWriter1.write(entry.getKey() + " ");
			outputStreamWriter1.write(entry.getValue().getHoten() + " ");
			outputStreamWriter1.write(entry.getValue().getNgaysinh() + " ");
			outputStreamWriter1.write(entry.getValue().getCMND() + " ");
			outputStreamWriter1.write(entry.getValue().getSDT() + " ");
			outputStreamWriter1.write(entry.getValue().getEmail() + " ");
			outputStreamWriter1.write(entry.getValue().getTrinhdo() + " ");
			outputStreamWriter1.write(entry.getValue().getVitri() + " ");
			outputStreamWriter1.write(entry.getValue().getLuong() + " ");
			outputStreamWriter1.write("\n");
			outputStreamWriter1.flush();
		}
		outputStreamWriter1.flush();
		outputStreamWriter1.close();
	}

	private static void addNewBook(Scanner sc) throws IOException {
		 Map<Integer, Customer> listCus = getDataCustomer();
		 List<Customer> lisCustomer = new ArrayList<Customer>();
		 List<Services> listSer = getServices();
		 String id = "";
		 Set<Map.Entry<Integer, Customer>> setListCusomter = listCus.entrySet();
		 Set<Map.Entry<Integer, Customer>> setDic = getDataCustomer().entrySet();
			for (Entry<Integer, Customer> entry : setDic) {
				System.out.println("STT " + entry.getKey() + "-->" + " Value: " + entry.getValue().getHoten());
			}
		 System.out.println("Enter key want to booking");
		 Integer key = Integer.parseInt(sc.nextLine());
		 for (Entry<Integer, Customer> entry : setListCusomter) {
			if (entry.getKey().equals(key)) {
				System.out.println("1.	Booking Villa");
				System.out.println("2.	Booking House");
				System.out.println("3.	Booking Room");
				int chose = Integer.parseInt(sc.nextLine());
				switch (chose) {
				case 1:
					for (Services ser : listSer) {
						if (ser instanceof Villa) {
							ser.showInfo();
						}
					}
					System.out.println("Enter id services want to chose");
					 id = sc.nextLine();
					for (Services ser : listSer) {
						if (ser instanceof Villa) {
							if (ser.getId().equals(id)) {
								entry.getValue().setDichvu(ser);
								lisCustomer.add(entry.getValue());
							}
						}
					}
					break;
				case 2:
					for (Services ser : listSer) {
						if (ser instanceof House) {
							ser.showInfo();
						}
					}
					System.out.println("Enter id services want to chose");
					 id = sc.nextLine();
					for (Services ser : listSer) {
						if (ser instanceof House) {
							if (ser.getId().equals(id)) {
								entry.getValue().setDichvu(ser);
								lisCustomer.add(entry.getValue());
							}
						}
					}
					break;
				case 3:
					for (Services ser : listSer) {
						if (ser instanceof Phong) {
							ser.showInfo();
						}
					}
					System.out.println("Enter id services want to chose");
					 id = sc.nextLine();
					for (Services ser : listSer) {
						if (ser instanceof Phong) {
							if (ser.getId().equals(id)) {
								entry.getValue().setDichvu(ser);
								lisCustomer.add(entry.getValue());
							}
						}
					}
				}
			}
		}
		savetoFileBooking(lisCustomer);
	}

	private static void savetoFileBooking(List<Customer> lisCustomer) throws IOException {
		File file1 = new File("E:\\hoc lap trinh\\data\\Booking.txt");
		OutputStream outputStream1 = null;
		OutputStreamWriter outputStreamWriter1 = null;
		outputStream1 = new FileOutputStream(file1,true);
		outputStreamWriter1 = new OutputStreamWriter(outputStream1);
		 for (Customer entry : lisCustomer) {
			outputStreamWriter1.write(entry.getHoten() + " ");
			outputStreamWriter1.write(entry.getNgaysinh() + " ");
			outputStreamWriter1.write(entry.getGioitinh() + " ");
			outputStreamWriter1.write(entry.getCMND() + " ");
			outputStreamWriter1.write(entry.getSDT() + " ");
			outputStreamWriter1.write(entry.getEmail() + " ");
			outputStreamWriter1.write(entry.getLoaiKhach() + " ");
			outputStreamWriter1.write(entry.getDiachi() + " ");
			outputStreamWriter1.write(entry.getDichvu().getId() + " ");
			outputStreamWriter1.write("\n");
			outputStreamWriter1.flush();
		}
		 outputStreamWriter1.close();
		 
	}

	
	private static void outPutCollection(Collection collection) {
		for (Object item : collection) {
            System.out.println(item);
        }
	}
	
	private static Map<Integer, Customer> getDataCustomer() throws IOException {
		Map<Integer, Customer> listCus = new HashMap<Integer, Customer>();
		String line1 = "";
		Integer i  = new Integer(0);
		BufferedReader bff1 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\data\\Customer.txt"));
		while ((line1 = bff1.readLine()) != null) {
			Customer cs = new Customer();
			String[] data = line1.split(" ");
			cs.setHoten(data[0]);
			cs.setNgaysinh(data[1]);
			cs.setGioitinh(data[2]);
			cs.setCMND(data[3]);
			cs.setSDT(data[4]);
			cs.setEmail(data[5]);
			cs.setLoaiKhach(data[6]);
			cs.setDiachi(data[7]);
			listCus.put(i++, cs);
			
		}
		Set<Entry<Integer, Customer>> set = listCus.entrySet();
		List<Entry<Integer, Customer>> list = new ArrayList<Entry<Integer, Customer>>(
                set);
//		Collections.sort(list, new Comparator<Map.Entry<Integer, Customer>>() {
//			@Override
//			public int compare(Entry<Integer, Customer> o1, Entry<Integer, Customer> o2) {
//				// TODO Auto-generated method stub
//				return o1.getValue().getHoten().compareTo(o2.getValue().getHoten());
//			}
//		});
		
//		Collections.sort(list,new sortbyHoten());
//		Collections.sort(list,new sortByID());
		bff1.close();
		return listCus;
	}

static class sortbyHoten implements Comparator<Map.Entry<Integer, Customer>>{

	@Override
	public int compare(Entry<Integer, Customer> o1, Entry<Integer, Customer> o2) {
		// TODO Auto-generated method stub
		return o1.getValue().getHoten().compareTo(o2.getValue().getHoten());
	}
	
}

static class sortByID implements Comparator<Map.Entry<Integer, Customer>>{

	@Override
	public int compare(Entry<Integer, Customer> o1, Entry<Integer, Customer> o2) {
		// TODO Auto-generated method stub
		return o1.getKey().compareTo(o2.getKey());
	}
	
}

	private static void addCustomer() {
		
//		Scanner sc = new Scanner(System.in);
		Customer cs = new Customer();
		cs.input();
//		System.out.println("Enter id services want to add for customer");
//		String id = sc.nextLine();
//		try {
//			List<Services> listServices = getServices();
//			for (Services services : listServices) {
//				if (services.getId().equals(id)) {
//					cs.setDichvu(services);
//				}
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		saveCusToFile(cs);
		
	}

	private static void saveCusToFile(Customer cs) {
		File file1 = new File("E:\\hoc lap trinh\\data\\Customer.txt");
		OutputStream outputStream1 = null;
		OutputStreamWriter outputStreamWriter1 = null;
		try {
			outputStream1 = new FileOutputStream(file1,true);
			outputStreamWriter1 = new OutputStreamWriter(outputStream1);
			try {
				outputStreamWriter1.write(cs.getHoten() + " ");
				outputStreamWriter1.write(cs.getNgaysinh() + " ");
				outputStreamWriter1.write(cs.getGioitinh() + " ");
				outputStreamWriter1.write(cs.getCMND() + " ");
				outputStreamWriter1.write(cs.getSDT() + " ");
				outputStreamWriter1.write(cs.getEmail() + " ");
				outputStreamWriter1.write(cs.getLoaiKhach() + " ");
				outputStreamWriter1.write(cs.getDiachi() + " ");
				outputStreamWriter1.write(cs.getDichvu().getId() + " ");
				outputStreamWriter1.write("\n");
				outputStreamWriter1.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outputStreamWriter1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	private static Set<Villa> transferVilla(List<Services> services) {
		Set<Villa> setVilla = new TreeSet<Villa>();
		for (Services ser : services) {
			if (ser instanceof Villa) {
				setVilla.add((Villa)ser);
			}
		}
		return setVilla;
	}
	
	private static Set<House> transferHouse(List<Services> services) {
		Set<House> setHouse = new TreeSet<House>();
		for (Services ser : services) {
			if (ser instanceof House) {
				setHouse.add((House)ser);
			}
		}
		return setHouse;
	}
	
	private static Set<Phong> transferPhong(List<Services> services) {
		Set<Phong> setRoom = new TreeSet<Phong>();
		for (Services ser : services) {
			if (ser instanceof Phong) {
				setRoom.add((Phong)ser);
			}
		}
		return setRoom;
	}

	private static void showServices(List<Services> services) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.	Show all Villa");
		System.out.println("2.	Show all House");
		System.out.println("3.	Show all Room");
		System.out.println("4.	Show All Name Villa Not Duplicate");
		System.out.println("5.	Show All Name House Not Duplicate");
		System.out.println("6.	Show All Name Name Not Duplicate");
		System.out.println("7.	Back to menu");
		System.out.println("8.	Exit");
		System.out.println("Enter your option");
		int chose = Integer.parseInt(sc.nextLine());
		switch (chose) {
		case 1:
			for (Services services2 : services) {
				if (services2 instanceof Villa) {
					services2.showInfo();
				}
			}
			break;
		case 2:
			for (Services services2 : services) {
				if (services2 instanceof House) {
					services2.showInfo();
				}
			}
			break;
		case 3:
			for (Services services2 : services) {
				if (services2 instanceof Phong) {
					services2.showInfo();
				}
			}
			break;
		case 4:
			for (Villa vl : transferVilla(services)) {
				vl.showInfo();
			}
			break;
		case 5:
			for (House hs : transferHouse(services)) {
				hs.showInfo();
			}
			break;
		case 6:
			for (Phong p : transferPhong(services)) {
				p.showInfo();
			}
			break;
		case 7:
			return;
		case 8:
			System.exit(0);
		default:
			break;
		}
	}

	private static List<Services> getServices() throws IOException {
		List<Services> listSer = new ArrayList<Services>();
		String line1 = "";
		String line2 = "";
		String line3 = "";
		BufferedReader bff1 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\data\\Villa.txt"));
		BufferedReader bff2 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\data\\House.txt"));
		BufferedReader bff3 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\data\\Room.txt"));
		while ((line1 = bff1.readLine()) != null) {
			Villa vl = new Villa();
			String[] data = line1.split(" ");
			vl.setId(data[0]);
			vl.setTenDV(data[1]);
			vl.setDtichSD(data[2]);
			vl.setChiPhi(Float.parseFloat(data[3]));
			vl.setSoLuong(Integer.parseInt(data[4]));
			vl.setKieuThue(data[5]);
			vl.setTieuchuanPhong(data[6]);
			vl.setMota(data[7]);
			vl.setDtichHoBoi(Float.parseFloat(data[8]));
			vl.setSoTang(Integer.parseInt(data[9]));
			listSer.add(vl);
		}
		while ((line2 = bff2.readLine()) != null) {
			House hs = new House();
			String[] data1 = line2.split(" ");
			hs.setId(data1[0]);
			hs.setTenDV(data1[1]);
			hs.setDtichSD(data1[2]);
			hs.setChiPhi(Float.parseFloat(data1[3]));
			hs.setSoLuong(Integer.parseInt(data1[4]));
			hs.setKieuThue(data1[5]);
			hs.setTieuchuanPhong(data1[6]);
			hs.setMota(data1[7]);
			hs.setSotang(Integer.parseInt(data1[8]));
			listSer.add(hs);
		}
		while ((line3 = bff3.readLine()) != null) {
			Phong p = new Phong();
			String[] data2 = line3.split(" ");
			p.setId(data2[0]);
			p.setTenDV(data2[1]);
			p.setDtichSD(data2[2]);
			p.setChiPhi(Float.parseFloat(data2[3]));
			p.setSoLuong(Integer.parseInt(data2[4]));
			p.setKieuThue(data2[5]);
			p.setDvFree(data2[6]);
			listSer.add(p);
		}
		bff1.close();
		bff2.close();
		bff3.close();
		return listSer;
	}

	private static void addNewServices(Scanner sc) {
		List<Services> listSer = new ArrayList<Services>();
		System.out.println("1. Add new villa");
		System.out.println("2. Add new house");
		System.out.println("3. Add new room");
		System.out.println("4. Back to menu");
		System.out.println("5. Exit");
		System.out.println("Enter your option");
			int chose = Integer.parseInt(sc.nextLine());
			switch (chose) {
			case 1:
				Services vl = new Villa();
				vl.input();
				listSer.add(vl);
				break;
			case 2:
				Services house = new House();
				house.input();
				listSer.add(house);
				break;
			case 3:
				Services room = new Phong();
				room.input();
				listSer.add(room);
				break;
			case 4 : 
				return;
			case 5:
				System.exit(0);
			}
			saveToFile(listSer);
	}

	private static void saveToFile(List<Services> listSer) {
		File file1 = new File("E:\\hoc lap trinh\\data\\Villa.txt");
		File file2 = new File("E:\\hoc lap trinh\\data\\House.txt");
		File file3 = new File("E:\\hoc lap trinh\\data\\Room.txt");
		OutputStream outputStream1 = null;
		OutputStream outputStream2 = null;
		OutputStream outputStream3 = null;
		OutputStreamWriter outputStreamWriter1 = null;
		OutputStreamWriter outputStreamWriter2 = null;
		OutputStreamWriter outputStreamWriter3 = null;
		try {
			outputStream1 = new FileOutputStream(file1,true);
			outputStream2 = new FileOutputStream(file2,true);
			outputStream3 = new FileOutputStream(file3,true);
			outputStreamWriter1 = new OutputStreamWriter(outputStream1);
			outputStreamWriter2 = new OutputStreamWriter(outputStream2);
			outputStreamWriter3 = new OutputStreamWriter(outputStream3);
			for (Services services : listSer) {
				if (services instanceof Villa) {
					try {
						outputStreamWriter1.write(services.getId() + " ");
						outputStreamWriter1.write(services.getTenDV() + " ");
						outputStreamWriter1.write(services.getDtichSD() + " ");
						outputStreamWriter1.write(services.getChiPhi() + " ");
						outputStreamWriter1.write(services.getSoLuong() + " ");
						outputStreamWriter1.write(services.getKieuThue() + " ");
						outputStreamWriter1.write(((Villa)services).getTieuchuanPhong() + " ");
						outputStreamWriter1.write(((Villa)services).getMota() + " ");
						outputStreamWriter1.write(((Villa)services).getDtichHoBoi() + " ");
						outputStreamWriter1.write(((Villa)services).getSoTang() + " ");
						outputStreamWriter1.write("\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if(services instanceof House) {
					try {
						outputStreamWriter2.write(services.getId() + " ");
						outputStreamWriter2.write(services.getTenDV() + " ");
						outputStreamWriter2.write(services.getDtichSD() + " ");
						outputStreamWriter2.write(services.getChiPhi() + " ");
						outputStreamWriter2.write(services.getSoLuong() + " ");
						outputStreamWriter2.write(services.getKieuThue() + " ");
						outputStreamWriter2.write(((House)services).getTieuchuanPhong() + " ");
						outputStreamWriter2.write(((House)services).getMota() + " ");
						outputStreamWriter2.write(((House)services).getSotang() + " ");
						outputStreamWriter2.write("\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					try {
						outputStreamWriter3.write(services.getId() + " ");
						outputStreamWriter3.write(services.getTenDV() + " ");
						outputStreamWriter3.write(services.getDtichSD() + " ");
						outputStreamWriter3.write(services.getChiPhi() + " ");
						outputStreamWriter3.write(services.getSoLuong() + " ");
						outputStreamWriter3.write(services.getKieuThue() + " ");
						outputStreamWriter3.write(services.getKieuThue() + " ");
						outputStreamWriter3.write(((Phong)services).getDvFree() + " ");
						outputStreamWriter3.write("\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					outputStreamWriter1.flush();
					outputStreamWriter2.flush();
					outputStreamWriter3.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outputStreamWriter1.close();
				outputStreamWriter2.close();
				outputStreamWriter3.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Department obj = new Department(1, "Books");
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		SellerDao sellerDao = DaoFactory.createSellerDao();

		Seller seller2 = sellerDao.findById(3);

		System.out.println(obj);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("/============== Teste 1_seller findById ========================/");
		System.out.println();

		System.out.println(seller2);
		
		System.out.println();
		System.out.println("/============== Teste 2_seller findByDepartment ================/");
		System.out.println();

		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj1 : list) {
			System.out.println(obj1);
		}
		
		System.out.println();
		System.out.println("/============== Teste 3_seller findAll =========================/");
		System.out.println();

		list = sellerDao.findAll();
		for (Seller obj1 : list) {
			System.out.println(obj1);
		}
		
		System.out.println();
		System.out.println("/============== Teste 4_seller insert ==========================/");
		System.out.println();

		Seller newSeller = new Seller(null, "Leonardo", "Leonardo@gmail.com", new Date(), 5000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new ID: "+newSeller.getId());
		
		System.out.println();
		System.out.println("/============== Teste 5_seller Update ==========================/");
		System.out.println();

		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("UPdate Complected!");
		
		System.out.println();
		System.out.println("/============== Teste 6_seller delete ==========================/");
		System.out.println();

		System.out.println("Enter id for Delete test: ");
		int id =sc.nextInt();
		seller = sellerDao.findById(id);
		sellerDao.deleteById(id);
		System.out.println("Delete Complected!");
		
		sc.close();

	}
}

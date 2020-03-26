package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

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

	}

}

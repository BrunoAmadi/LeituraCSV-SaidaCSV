package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {
public static void main(String[] arg) {
	
	Locale.setDefault(Locale.US);
	String path = "Produtos.csv";
	List<Product> listProduct = new ArrayList<>();
	
	try(BufferedReader br = new BufferedReader(new FileReader(path))) {
		
		boolean sucess = new File("C:" + "\\out").mkdir();
		
		String line = br.readLine();
		while(line != null) {
			String[] vectLine = line.split(",");
			String name = vectLine[0];
			double value = Double.parseDouble(vectLine[1]);
			int qntity = Integer.parseInt(vectLine[2]);
			Product product = new Product(name,value,qntity);
			listProduct.add(product);
			System.out.println(line);
			line = br.readLine();
			
		}
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\out\\summary.csv",true));
		for(Product product : listProduct) {
			
			bw.write(product.getName() + ",");
			bw.write(String.format("%.2f", product.totalPrice()));
			bw.newLine();
		}
		
		bw.close();
		
	}catch(IOException e) {
		System.out.println("error: " + e.getMessage());
	}catch(NullPointerException e ) {
		System.out.println("error: " + e.getMessage());
	}
	
	
}
}

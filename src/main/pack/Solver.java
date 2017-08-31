package main.pack;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import input.Order;
import input.Orders;
import output.Product;
import output.Products;

public class Solver {

	private String fileId;
	private Map<Product, String> map = new HashMap<Product, String>();

	public Solver() {

	}

	public  void parseXML(File file) {

		List<Product> productList = new ArrayList<>();
		fileId = file.getName().replaceAll("[^0-9]", ""); //capture the fire ID

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);				
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();				
			Orders customer = (Orders) jaxbUnmarshaller.unmarshal(new File(file.getName()));
			//Mirror input - output
			for (Order order : customer.getOrder()) {	
				for (input.Product inProduct : order.getProduct()) {
//					System.out.println(inProduct);
					output.Product outProduct = new Product();
					outProduct.setDescription(inProduct.getDescription());
					outProduct.setPrice(inProduct.getPrice());
					outProduct.setOrderid(order.ID);
					outProduct.setGtin(inProduct.getGtin());							
					productList.add(outProduct);
					map.put( outProduct,inProduct.getSupplier());
				}
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}

//		return productList;
	}

	public  void saveToXML() {
		//creates a list of vendors (Apple,Sony...) sorted with distinct members
		List<String> vendorList = map.values().stream().sorted().distinct().collect(Collectors.toList());
		//Iterate over the vendor list
		for (int i=0;i < vendorList.size();i++) {
			Products vendorSpecificList = new Products(); //create a product object just for a member
			List<output.Product> miniProductList = new ArrayList<>(); //holds the list of individual Product
			//iterate the whole map	
			for (Entry<Product, String> entry : map.entrySet()) {		
				//identify members of the distinct vendor
				if(vendorList.get(i).equals(entry.getValue())) {				
					miniProductList.add(entry.getKey()); //add to a subset
				}
			}

			vendorSpecificList.setProduct(miniProductList); //populate with subset
			printFile(vendorSpecificList,vendorList.get(i)); //prints the subset

		}
	}
	private  void printFile(Products print, String ufilename) {
		//creates filename and path
		File file = new File("output"+File.separator+ufilename+fileId+".xml"); 
		System.out.println("Exporting  : "+ file);
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Products.class); 
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			jaxbMarshaller.marshal(print, file); // prints the file
			//  		    jaxbMarshaller.marshal(products, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void moveFile(File file)   {
		//		System.out.println(file.getName());
		Path source = file.toPath();
		Path target = Paths.get( "archive" + File.separator + file.getName());
		try {
			Files.move(source, target,StandardCopyOption.REPLACE_EXISTING) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

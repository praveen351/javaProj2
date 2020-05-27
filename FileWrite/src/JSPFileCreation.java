import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JSPFileCreation {
	public static void main(String[] args) {
		String loc = "C:/Users/Praveen Kumar Samal/Desktop/Pages/HTMLFiles/";
		String locd = "C:/Users/Praveen Kumar Samal/Desktop/Pages/JSPFiles/";
		String[] text = {
				"<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\"\r\n"
						+ "	pageEncoding=\"ISO-8859-1\"%>\n",
				"<%@ taglib prefix=\"form\" uri=\"http://www.springframework.org/tags/form\"%>\n",
				"<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\"%>\n" };
		File file = new File(loc);
		FileReader fr = null;
		FileWriter fw = null;
		String[] fileList = file.list();
		for (String name : fileList) {
			String filename = name.replace("html", "jsp");
			int ch;
			try {
				fw = new FileWriter(locd.concat(filename));
				fr = new FileReader(loc.concat(name));
				for (String data : text)
					for (int i = 0; i < data.length(); i++) 
			            fw.write(data.charAt(i)); 				
				while ((ch=fr.read())!=-1) 
					fw.write((char)ch); 
				fr.close();
				fw.close();
			} catch (Exception e) {

			}
		}
	}
}

package taskTwo;


import java.io.*;

public class Saver {
	
	@SaveTo( path = "D:\\file.txt")
	public void savingSomeTextToFile(String path){
		TextContainer textContainer = new TextContainer();
		File file = new File(path);
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("File creating ERROR!");
		}
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write(textContainer.getSomeText());
			System.out.println("Writing success");
		} catch (IOException e) {
			System.out.println("Writting ERROR!");
		}
	}

	
}

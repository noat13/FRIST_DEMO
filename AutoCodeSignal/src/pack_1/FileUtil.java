package pack_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {
	public static final String PATH_SRC = "D:\\GitHub\\CodeFight\\Answer";
	public static boolean isFileContainString(String text, String fileName) {
		try {
			File file = new File(fileName);
			System.out.println("read file " + file.getCanonicalPath());
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String strLine;
				// Read lines from the file, returns null when end of stream
				// is reached
				while ((strLine = br.readLine()) != null) {
					if (strLine.contains(text)) {
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println("isFileContainString failed.");
			return false;
		}
	}
	
	public static void deleteFile(String fileName) {
    	try{
    		File file = new File(fileName);
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	public static void deleteFileWithText(String path, String text, boolean isContain) {
		try (Stream<Path> walk = Files.walk(Paths.get(path))) {

			List<String> result = walk.filter(Files::isRegularFile)
					.map(x -> x.toString()).collect(Collectors.toList());

			for (int i = 0; i < result.size(); i++) {
				if(isFileContainString(text, result.get(i)) == isContain) {
					deleteFile(result.get(i));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		deleteFileWithText(PATH_SRC + "\\JS","def ", true);
		deleteFileWithText(PATH_SRC + "\\C++","def ", true);
		deleteFileWithText(PATH_SRC + "\\Java","def ", true);
		deleteFileWithText(PATH_SRC + "\\Py2","def ", false);
		deleteFileWithText(PATH_SRC + "\\Py3","def ", false);
	}
	
}

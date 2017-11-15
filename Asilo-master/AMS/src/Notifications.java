import java.io.*;

public class Notifications  {

	private static String[] notifications;
	private static int numberOfNot;
	private static final int MAX_NOTIFICATIONS = 10;
	
	public Notifications() {
		notifications = new String[MAX_NOTIFICATIONS];
		numberOfNot = 0;
		
		String filename = "data/notifications.txt";
		
		String line = null;
		
		try { 
			FileReader fileReader = new FileReader(filename);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				addNotification(line);
			}
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file");
		}
		catch(IOException ex) {
			System.out.println("Error reading file");
		}
		
		
		
		
	}
	
	// initializer for test purposes
	
	private void saveFile() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		String s = "";
		
		for (int i = 0; i < numberOfNot; i++) {
			s = s.concat(notifications[i] + "\n");
		}
		
		
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("data/notifications.txt"), "utf-8"))) {
	   writer.write(s);
		}
	}
	
	
	public void addNotification(String n) throws UnsupportedEncodingException, FileNotFoundException, IOException  {
		notifications[numberOfNot] = n;
		numberOfNot++;
		
		saveFile();
		
	}
	
	public String getAllNotifications() {
		String r = "";
		
		for (int i = 0; i < numberOfNot; i++) {
			r = r.concat(notifications[i] + "\n");
		}
		
		return r;
	}
	
}

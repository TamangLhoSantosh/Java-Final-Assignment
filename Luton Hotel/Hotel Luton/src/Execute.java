import FrontendLayer.Main;

public class Execute {
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
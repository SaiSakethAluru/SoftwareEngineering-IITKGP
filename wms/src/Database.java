public class Database {
	protected static int size;
	
	public Database() {
		Database.size = 0;
	}
	public static int getSize() {
		return size;
	}
	public static void updateSize(int newSize) {
		Database.size = newSize;
	}
}


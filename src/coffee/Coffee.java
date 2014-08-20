package coffee;

public abstract class Coffee {
	public static String Small = "Small";
	public static String Medium = "Medium";
	public static String Large = "Large";
	public static String Size = null;
	public static String Liveliness = null;
	public static String Smooth = "Smooth";
	public static String Balanced = "Balanced";
	public static String Bright = "Bright";
	protected String description = "null";
	
	public String getLiveliness() {
		return Liveliness;
	}

	public void setLiveliness(String liveliness) {
		Liveliness = liveliness;
	}



	public String getDescription() {
		return description;
	}

	public String getSize() {
		return Size;
	}
    public void setSize(String Size1){
    	System.out.println(Size1);
    	Size=Size1;
    }

	public abstract double cost();
}

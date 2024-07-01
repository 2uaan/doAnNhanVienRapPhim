package model;

import java.awt.Font;

public class font {
	
	public Font consolas = new Font("Consolas", Font.BOLD | Font.ITALIC, 25);
	public Font sTZhongsong = new Font("STZhongsong", Font.BOLD, 59);
	public Font tilt_neon = new Font("Tilt Neon", Font.BOLD, 45);
	
	public Font setUTMfacebookKnT(int size) {
		Font font = new Font("UTM Facebook K&T", Font.BOLD, size);
		
		return font;
	}
	
	public Font setUTMtimes(int size) {
		Font font = new Font("UTM Times", Font.BOLD | Font.ITALIC, size);
		
		return font;
	}
	
	public Font setTilt_Neon_Size(int size) {
		Font tilt_neon = new Font("Tilt Neon", Font.BOLD, size);
		
		return tilt_neon;
	}
	
}

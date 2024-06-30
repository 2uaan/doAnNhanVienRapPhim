package model;

import java.awt.Font;

public class font {
	
	public Font consolas = new Font("Consolas", Font.BOLD | Font.ITALIC, 25);
	public Font sTZhongsong = new Font("STZhongsong", Font.BOLD, 59);
	public Font tilt_neon = new Font("Tilt Neon", Font.BOLD, 50);
	
	public Font setTilt_Neon_Size(int size) {
		Font tilt_neon = new Font("Tilt Neon", Font.BOLD, size);
		
		return tilt_neon;
	}
	
}

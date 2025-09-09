package Editor.Util;

/**
 * Represents color images.
 * Image data is represented as a matrix:
 * - the number of lines corresponds to the image height (data.length)
 * - the length of the lines corresponds to the image width (data[*].length)
 * - pixel color is encoded as integers (ARGB)
 */
public class ColorImage {

	private int[][] data; // @colorimage

	public ColorImage(String file) {
		this.data = ImageUtil.readColorImage(file);
	}

	public ColorImage(int width, int height) {
		data = new int[height][width];
	}

	public int getWidth() {
		return data[0].length;
	}

	public int getHeight() {
		return data.length;
	}

	public void setColor(int x, int y, Color c) {
		data[y][x] = ImageUtil.encodeRgb(c.getR(), c.getG(), c.getB());
	}

	public Color getColor(int x, int y) {
		int[] rgb = ImageUtil.decodeRgb(data[y][x]);
		return new Color(rgb[0], rgb[1], rgb[2]);
	}
	
	public void brighter(int value){
		for(int i = 0; i < getWidth(); i++)
			for(int j = 0; j < getHeight(); j++){
				// getColor(i,j); cor guardada em (i,j)
				// getColor(i,j).brighter(value); cor clareada/escurecida
				setColor( i, j, getColor(i,j).brighter(value) ); // colocar a cor clareada/escurecida
			}
	}

	// Aula 9 - ColorImage - A6) Fun��o para devolver uma 
			// ColorImage que � a c�pia do this.
	public ColorImage copy(){
		ColorImage c�pia = new ColorImage(this.getWidth(), this.getHeight());
		for(int i = 0; i < c�pia.getWidth(); i++)
			for(int j = 0; j < c�pia.getHeight(); j++)
				c�pia.setColor( i, j, this.getColor(i,j) );
		return c�pia;
	}
}
						
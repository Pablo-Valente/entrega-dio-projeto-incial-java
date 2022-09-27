package zeldaminiclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks extends Rectangle {

	public Blocks(int x, int y) {
		super(x,y,32,32);
		//super para exportar para outras classes, x e y = posicao, 32 e 32 para tamanho
	}
	
	public void render(Graphics g) {
//		g.setColor(Color.MAGENTA);
//		g.fillRect(x, y, width, height);
//		g.setColor(Color.black);
//		g.drawRect(x, y, width, height);
		
		//função para desenhar a sprite feita no Spritesheet.java
		g.drawImage(Spritesheet.tileWall, x, y, 32, 32, null);
		
	}
}

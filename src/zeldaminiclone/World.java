package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
		
		
		public static List<Blocks> blocks = new ArrayList<Blocks>();
		
		public World() {
			
			//matematica para multiplicação dos blocos
			//laço de repeticao for, xx=0; se for menos que 15; adicione mais um até chegar a 15
			//no blocks.add(new Blocks())
			
			//posicao superior dos blocos 	
			for(int xx = 0; xx < 15*2; xx++) {
				blocks.add(new Blocks(xx*32,0));
			}
			//posicao inferior
			for(int xx = 0; xx < 15*2; xx++) {
				blocks.add(new Blocks(xx*32,480-32));
			}
			//posicao esquerda
			for(int yy = 0; yy < 15*2; yy++) {
				blocks.add(new Blocks(0,yy*32));
			}
			//posicao direita
			for(int yy = 0; yy < 15*2; yy++) {
				blocks.add(new Blocks(640-32,yy*32));
			}
		}
		//sistema de colisao para resolução 480x480, em padrao com os blocos ja criados
		public static boolean isFree(int x, int y) {
			for(int i = 0; i < blocks.size(); i++) {
				Blocks blocoAtual = blocks.get(i);
				if(blocoAtual.intersects(new Rectangle(x,y,32,32))) {
					return false;
				}
			}
			
			return true;
		}
	
		//renderização dos blocos
		public void render(Graphics g) {
			for(int i = 0; i < blocks.size(); i++) {
				blocks.get(i).render(g);
			}
			
		}
}

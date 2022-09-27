package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//não esquecer de criar pasta nos arquivos do projeto
//não esquecer tambem de dar refresh no Package Explorer para adicionar a pasta nova
public class Spritesheet {
	
	//objeto para se referir a imagem completa com os sprites
	public static BufferedImage spritesheet;

	//objeto sprite do player, com Array para animação []
	public static BufferedImage[] player_front;
	
	//objeto para a imagem do muro la
	public static BufferedImage tileWall;
	
	//função para importar a imagem para o jogo
	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		player_front = new BufferedImage[2];
		
		player_front[0] = Spritesheet.getSprite(0, 11, 16, 16);
		player_front[1] = Spritesheet.getSprite(16, 11, 16, 16);
		tileWall = Spritesheet.getSprite(280,221,16,16);
	}
	
	//função para recortar a imagem
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
	

}

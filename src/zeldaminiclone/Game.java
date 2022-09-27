//ESSA É A RECEITA DE BOLO
package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	public static int WIDTH = 640, HEIGHT = 480;
	public static int SCALE = 3;
	public Player player;
	
	public World world;
	
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		new Spritesheet();
		
		player = new Player(32,32);
		world = new World();
		
	}
	
	//Responsavel pela logica que é a movimentação do Player/Colisões
	public void tick() {
		player.tick();
	}
	
	
	//Responsavel pela renderização dos gráficos
	public void render() {
		//primeiro comando para renderização
		BufferStrategy bs = this.getBufferStrategy();
			
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		//define o fundo preto para não ficar piscando, pode ser utilziado para adicionar outros fundos
		Graphics g = bs.getDrawGraphics();	
		
		g.setColor(new Color(0,135,13));
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		player.render(g);
		
		world.render(g);
		
		/*
		g.setColor(Color.red);
		g.fillRect(10, 10, 100, 100);
		*/
		
		bs.show();
	}
	
	
	//o que estiver abaixo do void main, sera executado primeiro
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Mini Zelda");
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		new Thread(game).start();
		}
	
	@Override
	public void run() {
			while(true) {
				tick();
				render();
				//Thread.sleep(1000/60)[para rodar o game a 60fps], dai converta para Try/Catch
				try {
					Thread.sleep(1000/60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
	
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
	
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				player.down = false;
		}
	}
	
	
	
	

}

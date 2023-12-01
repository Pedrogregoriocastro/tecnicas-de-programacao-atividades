package view;

import controller.JavaLarSystem;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Component;
import view.Elementos_do_grid.*;

public class GridDoSistema extends JPanel {
	protected ArrayList<Elementos> plano = new ArrayList<Elementos>();
	protected Elementos python = new PythonView();
	protected Elementos javascript = new JavascriptView();
	protected Elementos rubyonrails = new RubyonrailsView();
	protected Elementos PHP = new PHPView();
	protected Elementos csharp = new CsharpView();
	protected Elementos cpp = new CppView();
	protected Elementos c = new CView();
	protected Elementos java = new javaView();
	GridLayout layout = new GridLayout(15,15);
	
	
	protected GridDoSistema() {
		setLocation(20,70);
		setOpaque(false);
		setSize(750, 562);
		setLayout(layout);
		
		
		
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 15; x++) {
				
				if (x == 7 && y == 7) {
					plano.add(java);
				}else if (x == 8 && y == 7) {
					plano.add(python);
				}else if (x == 9 && y == 7) {
					plano.add(javascript);
				}else if (x == 10 && y == 7) {
					plano.add(rubyonrails);
				}else if (x == 11 && y == 7) {
					plano.add(PHP);
				}else if (x == 12 && y == 7) {
					plano.add(csharp);
				}else if (x == 13 && y == 7) {
					plano.add(cpp);
				}else if (x == 14 && y == 7) {
					plano.add(c);
				}else {
					plano.add(new Vazio(x,y));
				}
				
			}
		}
		
		
		for (Elementos elemento : plano) {
			add((Component) elemento);
		}
		
		
		setVisible(true);
	}
	

	public void atualizarGrid(int[] planetaspos, ArrayList<Integer> Devs , ArrayList<Integer> Bugs) {
		plano.clear();
		this.removeAll();
		completarPlano();
		reposicionarPlanetas(planetaspos);		
		colocarDevs(Devs);
		colocarBugs(Bugs);
		for (Elementos elemento : plano) {
			add((Component) elemento);
		}
		revalidate();
		repaint();
	}
	
	public void completarPlano() {
		int x = 0;
		int y = 0;
		for (int i = 0; i < 225; i++) {
			plano.add(new Vazio(x,y));
			y++;
			if(y == 15) {
				y = 0;
				x++;
			}
		}
	}
	
	public void colocarDevs(ArrayList<Integer> devs) {
		ArrayList<Integer> Devs = devs;
		for (Integer b : Devs) {
			plano.set(b, new Dev());
		}
	}
	
	public void colocarBugs(ArrayList<Integer> bugs) {
		ArrayList<Integer> Bugs = bugs;
		for (Integer a : Bugs) {
			plano.set(a, new Bug());
		}
	}
	
	public void reposicionarPlanetas(int[] posicoes) {
		plano.set(112, java);
		plano.set(posicoes[0], python);
		plano.set(posicoes[1], javascript);
		plano.set(posicoes[2], rubyonrails);
		plano.set(posicoes[3], PHP);
		plano.set(posicoes[4], csharp);
		plano.set(posicoes[5], cpp);
		plano.set(posicoes[6], c);
	}
	
}
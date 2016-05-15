package fr.iutval.labyrinthgame.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * @author TODO
 *
 */
public class MainWindow extends JFrame {
	/**
	 * 
	 */
	public TopArea topArea;
	/**
	 * 
	 */
	public BottomArea bottomArea;
	
	/**
	 * 
	 */
	public MainWindow() {
		this.setTitle("Labyrinth Game");
		this.setResizable(false);
		this.setSize(1080, 1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.topArea = new TopArea(this);
		
		this.bottomArea = new BottomArea(this);
		
		/*
		 * Split the page
		 */
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, this.topArea, this.bottomArea);
		splitPane.setOneTouchExpandable(true);
		
		/*
		 * Set divider location to 500px
		 */
		splitPane.setDividerLocation(950);
		
		/*
		 * Disable divider control
		 */
		splitPane.setEnabled(false);
		
		/*
		 * Set divider size to 1 px
		 */
		splitPane.setDividerSize(1);
		
		/*
		 * Add splitpane to basic Pane
		 */
		this.getContentPane().add(splitPane);
		
		/*
		 * Set the result visible
		 */
		this.setVisible(true);
	}
}

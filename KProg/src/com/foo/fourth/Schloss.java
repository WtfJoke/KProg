package com.foo.fourth;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Frame, which is used to guess a secret code
 * 
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 *
 */
public class Schloss extends JFrame {
	private static final long serialVersionUID = 2624446559320231971L;
	private static final int DEFAULTBUTTONSWAPDELAY = (int) TimeUnit.SECONDS.toMillis(1);
	private static final int AMOUNTOFBUTTONS = 10;
	private List<Integer> unlockCode;
	private final int buttonswapdelay;

	public Schloss() {
		this(DEFAULTBUTTONSWAPDELAY);
	}

	public Schloss(int rotationSpeed) {
		buttonswapdelay = rotationSpeed;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.createUnlockCode();
		this.addButtons();
		this.pack(); // packs the gui in order to make it look good
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Schloss();
		new Schloss();
	}

	/**
	 * Secret unlock code is created here
	 */
	private void createUnlockCode() {
		unlockCode = new ArrayList<>();
		unlockCode.add(Integer.valueOf(0));
		unlockCode.add(Integer.valueOf(7));
		unlockCode.add(Integer.valueOf(0));
		unlockCode.add(Integer.valueOf(4));
		unlockCode.add(Integer.valueOf(1));
		unlockCode.add(Integer.valueOf(2));
	}

	/**
	 * Add the buttons to the frame
	 */
	private void addButtons() {
		List<JButton> buttons = createButtons();
		ButtonDrawer drawer = new ButtonDrawer();
		drawer.createPanels();
		drawer.fillPanels(buttons);
		getContentPane().add(drawer.getEastButtonPanel(), BorderLayout.EAST);
		getContentPane().add(drawer.getNorthButtonPanel(), BorderLayout.NORTH);
		getContentPane().add(drawer.getSouthButtonPanel(), BorderLayout.SOUTH);
		getContentPane().add(drawer.getWestButtonPanel(), BorderLayout.WEST);
		startButtonSwapper(buttons, drawer);
	}

	private List<JButton> createButtons() {
		List<JButton> buttons = new ArrayList<>();
		UnlockMouseListener unlockActionListener = new UnlockMouseListener(unlockCode, buttons);
		for (int i = 0; i < AMOUNTOFBUTTONS; i++) {
			JButton button = new JButton(String.valueOf(i));
			Dimension dimension = new Dimension(75, 75);
			buttons.add(button);
			button.setSize(dimension);
			button.setActionCommand(button.getText());
			button.setBackground(Color.green);
			button.addMouseMotionListener(unlockActionListener);
		}
		return buttons;
	}

	/**
	 * Add a timer which rotates the buttons
	 */
	private void startButtonSwapper(List<JButton> buttons, ButtonDrawer btDrawerRef) {
		Timer timer = new Timer(buttonswapdelay, new RotateButtons(buttons, btDrawerRef));
		timer.start();
	}

	public static void createFasterSchloss() {
		// int oldDelay = .getDelay();
		// int newDelay = (int) (oldDelay - oldDelay * 0.5); // increase by 50%
		// new Schloss(newDelay);
	}
}

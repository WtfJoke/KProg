package com.foo.third;

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
	private static final int BUTTONSWAPDELAY = (int) TimeUnit.SECONDS.toMillis(1);
	private static final int AMOUNTOFBUTTONS = 10;
	private List<Integer> unlockCode;

	public Schloss() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		createUnlockCode();
		addButtons();
		pack(); // packs the gui in order to make it look good
		setVisible(true);
	}

	public static void main(String[] args) {
		new Schloss();
	}

	/**
	 * Secret unlock code is created here
	 */
	private void createUnlockCode() {
		unlockCode = new ArrayList<>();
		unlockCode.add(Integer.valueOf(2));
		unlockCode.add(Integer.valueOf(3));
		unlockCode.add(Integer.valueOf(0));
		unlockCode.add(Integer.valueOf(3));
		unlockCode.add(Integer.valueOf(6));
		unlockCode.add(Integer.valueOf(0));
	}

	/**
	 * Add the buttons to the frame
	 */
	private void addButtons() {
		List<JButton> buttons = createButtons();
		ButtonDrawer.fillPanels(buttons);
		getContentPane().add(ButtonDrawer.getEastButtonPanel(), BorderLayout.EAST);
		getContentPane().add(ButtonDrawer.getNorthButtonPanel(), BorderLayout.NORTH);
		getContentPane().add(ButtonDrawer.getSouthButtonPanel(), BorderLayout.SOUTH);
		getContentPane().add(ButtonDrawer.getWestButtonPanel(), BorderLayout.WEST);
		startButtonSwapper(buttons);
	}

	private List<JButton> createButtons() {
		List<JButton> buttons = new ArrayList<>();
		UnlockActionListener unlockActionListener = new UnlockActionListener(unlockCode, buttons);
		for (int i = 0; i < AMOUNTOFBUTTONS; i++) {
			JButton button = new JButton(String.valueOf(i));
			Dimension dimension = new Dimension(75, 75);
			buttons.add(button);
			button.setSize(dimension);
			button.setActionCommand(button.getText());
			button.setBackground(Color.green);
			button.addActionListener(unlockActionListener);
		}
		return buttons;
	}

	/**
	 * Add a timer which rotates the buttons
	 */
	private void startButtonSwapper(List<JButton> buttons) {
		new Timer(BUTTONSWAPDELAY, new RotateButtons(buttons)).start();
	}
}

package com.foo.third;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import com.foo.second.WindowQuitter;

/**
 * Frame, which is used to guess a secret code
 * 
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 *
 */
public class Schloss extends JFrame {
	private static final int BUTTONSWAPDELAY = (int) TimeUnit.SECONDS.toMillis(1);
	private static final long serialVersionUID = 2624446559320231971L;
	private static final int AMOUNTOFBUTTONS = 10;
	private List<Integer> unlockCode;

	public Schloss() {
		addWindowListener(new WindowQuitter());
		getContentPane().setLayout(new BorderLayout());
		createUnlockCode();
		addButtons();
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Schloss();
	}

	private void createUnlockCode() {
		unlockCode = new ArrayList<>();
		unlockCode.add(Integer.valueOf(2));
		unlockCode.add(Integer.valueOf(3));
		unlockCode.add(Integer.valueOf(0));
		unlockCode.add(Integer.valueOf(3));
		unlockCode.add(Integer.valueOf(6));
		unlockCode.add(Integer.valueOf(0));
	}

	private void addButtons() {
		List<JButton> buttons = createButtons();
		ButtonDrawer.draw(buttons);
		getContentPane().add(ButtonDrawer.getEastButtonPanel(), BorderLayout.EAST);
		getContentPane().add(ButtonDrawer.getNorthButtonPanel(), BorderLayout.NORTH);
		getContentPane().add(ButtonDrawer.getSouthButtonPanel(), BorderLayout.SOUTH);
		getContentPane().add(ButtonDrawer.getWestButtonPanel(), BorderLayout.WEST);
		startButtonSwapper(buttons);
	}

	private List<JButton> createButtons() {
		UnlockActionListener unlockActionListener = new UnlockActionListener(this, unlockCode);
		List<JButton> buttons = new ArrayList<>();
		for (int i = 0; i < AMOUNTOFBUTTONS; i++) {
			JButton button = new JButton(String.valueOf(i));
			Dimension dimension = new Dimension(75, 75);
			buttons.add(button);
			button.setSize(dimension);
			button.setActionCommand(button.getText());
			button.addActionListener(unlockActionListener);
		}
		return buttons;
	}

	private void startButtonSwapper(List<JButton> buttons) {
		new Timer(BUTTONSWAPDELAY, new SwapButtons(buttons)).start();
	}
}

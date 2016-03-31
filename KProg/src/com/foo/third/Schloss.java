package com.foo.third;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import com.foo.second.UnlockActionListener;
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
	private static final long serialVersionUID = 2624446559320231971L;
	private static final int AMOUNTOFBUTTONS = 10;
	private List<Integer> unlockCode;

	public Schloss() {
		addWindowListener(new WindowQuitter());
		setSize(600, 300);
		setVisible(true);
		// GridLayout layout = new GridLayout(4, 3);
		LayoutManager layout = new BorderLayout();
		getContentPane().setLayout(layout);
		createUnlockCode();
		addButtons();
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

	public static void main(String[] args) {
		new Schloss();
	}

	private void addButtons() {
		List<JButton> buttons = createButtons();
		ButtonDrawer.draw(buttons);
		getContentPane().add(ButtonDrawer.getEastButtonPanel(), BorderLayout.EAST);
		getContentPane().add(ButtonDrawer.getNorthButtonPanel(), BorderLayout.NORTH);
		getContentPane().add(ButtonDrawer.getSouthButtonPanel(), BorderLayout.SOUTH);
		getContentPane().add(ButtonDrawer.getWestButtonPanel(), BorderLayout.WEST);
		// JPanel subPanel = new JPanel();
		// subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
		//
		// subPanel.add(new JButton("1"));
		// subPanel.add(new JButton("2"));
		// subPanel.add(new JButton("3"));
		// getContentPane().add(subPanel, BorderLayout.LINE_START);
		// startButtonSwapper(buttons);
	}

	private List<JButton> createButtons() {
		UnlockActionListener unlockActionListener = new UnlockActionListener(this, unlockCode);
		List<JButton> buttons = new ArrayList<>();
		for (int i = 0; i < AMOUNTOFBUTTONS; i++) {
			JButton button = new JButton(String.valueOf(i));
			buttons.add(button);
			button.setActionCommand(button.getText());
			button.addActionListener(unlockActionListener);
		}
		return buttons;
	}

	private void startButtonSwapper(List<JButton> buttons) {
		new Timer((int) TimeUnit.SECONDS.toMillis(1), new SwapButtons(this, buttons)).start();
	}
}

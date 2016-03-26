package com.foo.second;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame, which holds two button. <br>
 * - One which changes the background color <br>
 * - One which opens a new frame
 * 
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 */
public class FarbClones extends Frame {

	private static final long serialVersionUID = 3175136255486722145L;
	private Button cycleColorButton = new Button("Cycle BG-Color");
	private Button openNewWindowButton = new Button("Open new Window");

	public FarbClones() {
		addWindowListener(new WindowQuitter());
		setSize(400, 300);
		setVisible(true);
		setLayout(new FlowLayout());
		add(cycleColorButton);
		add(openNewWindowButton);
		cycleColorButton.addActionListener(new SwitchColorActionListener(this, ColorPicker.getColors()));
		openNewWindowButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FarbClones();
			}
		});

	}

	public static void main(String[] args) {
		new FarbClones();
	}

}

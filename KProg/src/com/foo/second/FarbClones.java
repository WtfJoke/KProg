package com.foo.second;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FarbClones extends Frame {

	private Button cycleColorButton = new Button("Cycle BG-Color");
	private static final long serialVersionUID = 3175136255486722145L;

	public FarbClones() {
		setLayout(new FlowLayout());
		add(cycleColorButton);
		cycleColorButton.addActionListener(new SwitchColorActionListener(this));
	}

	public static void main(String[] args) {
		FarbClones frm = new FarbClones();
		frm.addWindowListener(new WindowQuitter());
		frm.setSize(400, 300);
		frm.setVisible(true);
	}

}

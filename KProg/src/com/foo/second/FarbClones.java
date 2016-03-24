package com.foo.second;

import java.awt.FlowLayout;
import java.awt.Frame;

public class FarbClones extends Frame {

	private static final long serialVersionUID = 3175136255486722145L;

	public FarbClones() {
		setLayout(new FlowLayout());
	}

	public static void main(String[] args) {
		DutzendFarben frm = new DutzendFarben();
		frm.addWindowListener(new WindowQuitter());
		frm.setSize(400, 300);
		frm.setVisible(true);
	}

}

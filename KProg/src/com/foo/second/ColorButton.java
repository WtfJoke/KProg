package com.foo.second;

import java.awt.Button;
import java.awt.Color;

/**
 * Button which is extended with a {@link Color}
 *
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 */
public class ColorButton extends Button {

	private static final long serialVersionUID = 1603665485889917484L;
	private final Color color;

	public ColorButton(Color color, String label) {
		super(label);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

}

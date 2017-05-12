package com.maximcedaroff.sounpoolont;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

public class ToggleableRadioButton extends android.support.v7.widget.AppCompatRadioButton {
	public ToggleableRadioButton(Context context) {
		super(context);
	}

	public ToggleableRadioButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ToggleableRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	// Implement necessary constructors

	@Override
	public void toggle() {
		if (isChecked()) {
			if (getParent() instanceof RadioGroup) {
				((RadioGroup) getParent()).clearCheck();
			}
		} else {
			setChecked(true);
		}
	}
} 
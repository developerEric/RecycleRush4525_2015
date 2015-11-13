package org.usfirst.frc.team4525.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSettings {
	
	private SendableChooser auto_choose;
	
	public enum AutoMode {
		Nothing, To_Autozone, Bin_To_Autozone, Bin_Prepare_Noodle, Cross_Field, Far_Start_Spin_Grab;
	}

	
	public DriveSettings() {
		// Create Selecting
		auto_choose = new SendableChooser();
		auto_choose.addDefault("Do Nothing", AutoMode.Nothing);
		auto_choose.addObject("To Autozone", AutoMode.To_Autozone);
		auto_choose.addObject("Drag Bin To Autozone", AutoMode.To_Autozone);
		auto_choose.addObject("Prepare To Noodle Bin ", AutoMode.Bin_Prepare_Noodle);
		auto_choose.addObject("Get Far Bin across Field", AutoMode.Cross_Field);
		auto_choose.addObject("Far Spin & Grab Bin To Autozone", AutoMode.Far_Start_Spin_Grab);
		
		// Send to Smartdashboard Client
		SmartDashboard.putData("Automiton Chooser", auto_choose);
		
	}
	
	public AutoMode getSelectedAuto() {
		return (AutoMode)auto_choose.getSelected();
	}
	
}

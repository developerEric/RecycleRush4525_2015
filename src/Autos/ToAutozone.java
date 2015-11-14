package Autos;

import org.usfirst.frc.team4525.robot.commands.ClawTilt;
import org.usfirst.frc.team4525.robot.commands.DriveDistance;
import org.usfirst.frc.team4525.robot.commands.DriveSpin;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ToAutozone extends CommandGroup {
    
    public  ToAutozone() {
    	addSequential(new ClawTilt(ClawTilt.Position.UP));
    	// Cross into Autozone
    	addSequential(new DriveDistance(75,0.4)); // Go to middle of Autozone
    	// Turns right to FIT into Autozone
    	addSequential(new DriveSpin(90,0.5));
    }
}

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
    	// Clear First Bump
    	addSequential(new ClawTilt(ClawTilt.Position.UP));
    	// Clear Bump
    	addSequential(new DriveDistance(22,0.4));
    	// Move Into Autozone just a tad more
    	addSequential(new DriveDistance(15,0.5));
    	// Get Into Autozone
    	addSequential(new DriveSpin(90,0.5));
    }
}

package Autos;

import org.usfirst.frc.team4525.robot.commands.Claw;
import org.usfirst.frc.team4525.robot.commands.ClawTilt;
import org.usfirst.frc.team4525.robot.commands.DriveDistance;
import org.usfirst.frc.team4525.robot.commands.DriveSpin;
import org.usfirst.frc.team4525.robot.commands.ExtendBoom;
import org.usfirst.frc.team4525.robot.commands.WinchPosition;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FarSpinGrab extends CommandGroup {
    
    public  FarSpinGrab() {
    	addSequential(new ClawTilt(ClawTilt.Position.UP));
    	addSequential(new WinchPosition(1000));
    	// Spin
    	addSequential(new DriveSpin(-90,0.5));
    	
    	// Drive into totes
    	addSequential(new DriveDistance(10,0.5));
    	// Extend Boom
    	addSequential(new ExtendBoom(ExtendBoom.Position.Full_Forwards));
    	
    	// Get bin
    	addSequential(new Claw(Claw.Position.GRIP));
    	Timer.delay(0.5);
    	
    	// Get to Autozone
      	addSequential(new WinchPosition(2000));
    	addSequential(new ExtendBoom(ExtendBoom.Position.Full_Backwards));
    	
    	// Back Off to Autozone
    	addParallel(new WinchPosition(1300)); // Lower a tad
    	addSequential(new DriveDistance(-40,0.5));
    	
    	// Final Spin in Autozone
    	addSequential(new DriveSpin(90,0.5));
    }
}

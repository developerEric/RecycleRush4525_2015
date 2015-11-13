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
public class CrossFieldGameOnAuto extends CommandGroup {
    
    public  CrossFieldGameOnAuto() {
    	// Tilt Claw to grab bin
    	addSequential(new ClawTilt(ClawTilt.Position.UP));
    	addParallel(new WinchPosition(1000));
    	// Clear bump
    	addSequential(new DriveDistance(22,0.4));
    	// Extend Arm
    	addParallel(new ExtendBoom(ExtendBoom.Position.Full_Forwards));
    	// Drive across field
    	addSequential(new DriveDistance(86, 0.5));
    	// Get Ready to grab bin
    	// Not sure if this will work!?
    	while(!isFinished()); // Wait until all Commands are done
    	
    	Timer.delay(0.1);
    	addParallel(new Claw(Claw.Position.GRIP));
    	Timer.delay(0.5);
    	
    	// This is where we had problerms last year hmmm..
    	addSequential(new WinchPosition(2000));
    	addSequential(new ExtendBoom(ExtendBoom.Position.Full_Backwards));
    	
    	// Back Off to Autozone
    	addParallel(new WinchPosition(1300)); // Lower a tad
    	addSequential(new DriveDistance(-40,0.5));
    	
    	// Final Spin in Autozone
    	addSequential(new DriveSpin(90,0.5));
    	
    }
}

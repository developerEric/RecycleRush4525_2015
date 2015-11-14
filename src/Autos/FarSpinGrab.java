package Autos;

import org.usfirst.frc.team4525.robot.commands.Claw;
import org.usfirst.frc.team4525.robot.commands.ClawTilt;
import org.usfirst.frc.team4525.robot.commands.DriveDistance;
import org.usfirst.frc.team4525.robot.commands.DriveSpin;
import org.usfirst.frc.team4525.robot.commands.ExtendBoom;
import org.usfirst.frc.team4525.robot.commands.WinchBrake;
import org.usfirst.frc.team4525.robot.commands.WinchPosition;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FarSpinGrab extends CommandGroup {
    
    public  FarSpinGrab() {
    	// Prepare Claw
    	addSequential(new ClawTilt(ClawTilt.Position.UP));
    	addSequential(new Claw(Claw.Position.OPEN));
    	//
    	addSequential(new WinchPosition(1000));
    	addParallel(new WinchBrake());
    	// Spin
    	addSequential(new DriveSpin(90,0.5));
    	
    	// Drive into totes
    	addSequential(new DriveDistance(5,0.5));
    	
    	// Extend Boom
    	addSequential(new ExtendBoom(ExtendBoom.Position.Full_Forwards));
    	
    	// Get bin
    	addSequential(new Claw(Claw.Position.GRIP));
    	Timer.delay(0.5);
    	
    	// Get to Autozone
      	addSequential(new WinchPosition(2000));
      	
      	// ExtendBoom also runs winch brake
    	addSequential(new ExtendBoom(ExtendBoom.Position.Full_Backwards));
    	
    	// Lower just a tad
    	addParallel(new WinchPosition(1300)); // Lower a tad
    	
    	// Back Off to Autozone
    	addSequential(new DriveDistance(-57,0.5)); // Lowered from 70
    	
    	// Final Spin in Autozone
    	addSequential(new DriveSpin(90,0.5));
    	addSequential(new WinchPosition(400));
    	
    	// Drop
    	//addSequential(new Claw(Claw.Position.OPEN));
    }
}

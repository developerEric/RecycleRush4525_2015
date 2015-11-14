package Autos;

import org.usfirst.frc.team4525.robot.commands.Claw;
import org.usfirst.frc.team4525.robot.commands.ClawTilt;
import org.usfirst.frc.team4525.robot.commands.DriveDistance;
import org.usfirst.frc.team4525.robot.commands.DriveSpin;
import org.usfirst.frc.team4525.robot.commands.WinchBrake;
import org.usfirst.frc.team4525.robot.commands.WinchPosition;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ToteToAutozone extends CommandGroup {
    
    public  ToteToAutozone() {
    	// Claw starts open!?
    	//addSequential(new ClawTilt(ClawTilt.Position.DOWN));
    	addSequential(new ClawTilt(ClawTilt.Position.UP));
    	Timer.delay(0.5);
    	// Drive Robot into tote
    	addSequential(new DriveDistance(10,0.4));

    	// Grab the Tote
    	addSequential(new Claw(Claw.Position.GRIP));
    	// Rise up a little
    	addSequential(new WinchPosition(100));
    	addParallel(new WinchBrake());
    	// Drive to Autozone
    	addSequential(new DriveDistance(-80,0.4)); // 94 Inches
    	// Move Into Autozone just a tad more
    	// Get Into Autozone
    	addSequential(new DriveSpin(-90,0.5)); 
    	
    	// Drop the Tote
    	//addSequential(new Claw(Claw.Position.OPEN));
    }
}

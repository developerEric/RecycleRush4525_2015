package Autos;

import org.usfirst.frc.team4525.robot.commands.Claw;
import org.usfirst.frc.team4525.robot.commands.ClawTilt;
import org.usfirst.frc.team4525.robot.commands.DriveDistance;
import org.usfirst.frc.team4525.robot.commands.DriveSpin;
import org.usfirst.frc.team4525.robot.commands.WinchPosition;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BinToAutozone extends CommandGroup {
    
    public  BinToAutozone() {
    	// Claw starts down!!?
    	addSequential(new ClawTilt(ClawTilt.Position.UP));
    	Timer.delay(0.5);
    	// Grab the Bin
    	addSequential(new Claw(Claw.Position.GRIP));
    	addParallel(new WinchPosition(500));
    	// Drive to Autozone
    	addSequential(new DriveDistance(-22,0.4));
    	// Move Into Autozone just a tad more
    	addSequential(new DriveDistance(-15,0.5));
    	// Get Into Autozone
    	addSequential(new DriveSpin(-90,0.5));   	
    }
}

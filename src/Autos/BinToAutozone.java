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
 * The Auto Ratio for Encoders is 0.85
 */
public class BinToAutozone extends CommandGroup {
    
    public  BinToAutozone() {
    	// Claw starts down!!?
    	addSequential(new ClawTilt(ClawTilt.Position.UP));
    	Timer.delay(0.5);
    	// Grab the Bin
    	addSequential(new Claw(Claw.Position.GRIP));
    	addSequential(new WinchPosition(500));
    	addParallel(new WinchBrake());
    	// Drive to Autozone
    	addSequential(new DriveDistance(-80,0.4)); // 94 Inches
    	// Move Into Autozone just a tad more
    	// Get Into Autozone
    	addSequential(new DriveSpin(-90,0.5)); 
    	
    	// IF WE HAVE TO DROP THE BIN:
    	/*addSequential(new Claw(Claw.Position.OPEN));
    	addParallel(new WinchPosition(100));
    	// Back off bin
    	addSequential(new DriveDistance(-5, 0.4)); */
    }
}

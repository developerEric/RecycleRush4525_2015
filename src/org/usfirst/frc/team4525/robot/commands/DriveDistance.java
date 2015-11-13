
package org.usfirst.frc.team4525.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4525.robot.Robot;
/**
 *
 */
public class DriveDistance extends Command {

	private static int finalDistance = 0;
	private static double power;
	
	private boolean complete = false;
	
    public DriveDistance(int distance, double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
        requires(Robot.pos);
        // Sensor Dependancies
        
        // Auto Drive Dependancies
        finalDistance = distance;
        power = speed;
        //
        if (finalDistance < 0 && power > 0) {
        	power = power*-1;
        }
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.pos.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if((finalDistance > 0 && Robot.pos.distance() < finalDistance) || (finalDistance < 0 && Robot.pos.distance() > finalDistance)) {
    		double offset = -Robot.pos.angle() * 0.15;
    		if (offset > 0.15) offset = 0.15;
    		if (offset < -0.15) offset = -0.15;
    		Robot.drive.arcadeDrive(offset,power);
    	} else {
        	this.end();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return complete;
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.drive.arcadeDrive(0, 0);
		complete = true;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		Robot.drive.arcadeDrive(0, 0);
    }
}

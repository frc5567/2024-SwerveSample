package frc.robot.commands;

import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.constants.RobotMap;
import frc.robot.subsystems.CommandSwerveDrivetrain;

public class TeleopDriveCommand extends Command{

    private CommandXboxController m_pilot;
    private CommandSwerveDrivetrain m_drive;

    private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
        .withDeadband(RobotMap.DrivetrainConstants.MAX_SPEED * RobotMap.DrivetrainConstants.DRIVE_DEADBAND)
        .withRotationalDeadband(RobotMap.DrivetrainConstants.MAX_ANGULAR_RATE * RobotMap.DrivetrainConstants.ROTATE_DEADBAND) // Add deadband
        .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // I want field-centric driving in open loop

    public TeleopDriveCommand(CommandXboxController pilot, CommandSwerveDrivetrain drivetrain) {
        m_pilot = pilot;
        m_drive = drivetrain;

        addRequirements(m_drive);
    }

    @Override
    public void initialize() {
        m_drive.setControl(new SwerveRequest.SwerveDriveBrake());
    }

    @Override
    public void execute() {
        double rotate = (-m_pilot.getRightX() * RobotMap.DrivetrainConstants.MAX_ANGULAR_RATE);
        m_drive.setControl(drive.withVelocityX(-m_pilot.getLeftY() * RobotMap.DrivetrainConstants.MAX_SPEED) // Drive forward with  negative Y (forward)
                    .withVelocityY(-m_pilot.getLeftX() * RobotMap.DrivetrainConstants.MAX_SPEED) // Drive left with negative X (left)
                    .withRotationalRate( rotate )); // Drive counterclockwise with negative X (left)
    }

    @Override
    public void end(boolean interrupted) {
        m_drive.setControl(new SwerveRequest.SwerveDriveBrake());
    }   

    @Override
    public boolean isFinished() {
        return false;
    }
    
}

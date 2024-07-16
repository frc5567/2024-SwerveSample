// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.Utils;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.constants.RobotMap;
import frc.robot.constants.TunerConstants;

public class RobotContainer {
  /* Setting up bindings for necessary control of the swerve drive platform */
   private final CommandXboxController pilot = new CommandXboxController(RobotMap.PilotControllerConstants.XBOX_CONTROLLER_USB_PORT);
  
  public final frc.robot.subsystems.CommandSwerveDrivetrain drivetrain = TunerConstants.DriveTrain; // My drivetrain

  private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();

  private final SwerveRequest.RobotCentric forwardStraight = new SwerveRequest.RobotCentric().withDriveRequestType(DriveRequestType.OpenLoopVoltage);

  private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();

  /* Path follower */
  private Command runAuto = drivetrain.getAutoPath("Tests");

  private final Telemetry logger = new Telemetry(RobotMap.DrivetrainConstants.MAX_SPEED);

  private void configureBindings() {
    if (Utils.isSimulation()) {
      drivetrain.seedFieldRelative(new Pose2d(new Translation2d(), Rotation2d.fromDegrees(0)));
    }
    
    // The following section is where the "commands" for the drivetrain are being
    // bound to the controls. This isn't the clearest way to demonstrate this but leaving for now
    // eventually need to split out commands to show how they are bound in a more clear way.
    // Since the CTRE drivetrain is architected around the FieldCentric Requset model, we need to probably
    // keep as is for the time being.
    drivetrain.setDefaultCommand(new TeleopDriveCommand(pilot, drivetrain).ignoringDisable(false));

    // When A is pressed on Joystick 0 -- brake the bot
    pilot.a().whileTrue(drivetrain.applyRequest(() -> brake));
    
    // When B is pressed on Joystick 0 -- point the wheels at the joystick direction
    pilot.b().whileTrue(drivetrain.applyRequest(() -> point.withModuleDirection(new Rotation2d(-pilot.getLeftY(), -pilot.getLeftX()))));

    // reset the field-centric heading on left bumper press
    pilot.leftBumper().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldRelative()));

    // if (Utils.isSimulation()) {
    //   drivetrain.seedFieldRelative(new Pose2d(new Translation2d(), Rotation2d.fromDegrees(90)));
    // }
    drivetrain.registerTelemetry(logger::telemeterize);

    pilot.pov(0).whileTrue(drivetrain.applyRequest(() -> forwardStraight.withVelocityX(RobotMap.DrivetrainConstants.CRAWL_SPEED).withVelocityY(0)));
    
    pilot.pov(180).whileTrue(drivetrain.applyRequest(() -> forwardStraight.withVelocityX(-RobotMap.DrivetrainConstants.CRAWL_SPEED).withVelocityY(0)));

  }

  public RobotContainer() {
    configureBindings();
  }

  public Command getAutonomousCommand() {
    /* First put the drivetrain into auto run mode, then run the auto */
    return runAuto;
  }
}
